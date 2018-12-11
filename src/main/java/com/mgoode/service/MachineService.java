package com.mgoode.service;

import com.mgoode.repository.MachineRepository;
import com.mgoode.model.Duty;
import com.mgoode.model.Flowrate;
import com.mgoode.model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

/**
 * Created by michaelgoode on 22/06/2017.
 */

@Component("machineService")
@Transactional
public class MachineService {

    @Autowired
    MachineRepository machineRepository;

    public Page<Machine> getMachines(int page, int totalLines) {
        return this.machineRepository.findAll( new PageRequest(page,totalLines) );
    }

    public Machine findMachine( Long id ) {
        return this.machineRepository.findOne(id);
    }

    public Iterable<Machine> searchByPressureBlowerGas(boolean blower, boolean vacuum, String cooling, float minPressure, float maxPressure) {
        return this.machineRepository.findMachinesByPressureBlowerGas(cooling, minPressure, maxPressure);
    }

    public Iterable<Machine> searchByPressureOtherGas(boolean blower, boolean vacuum, String cooling, double compressionRatio) {
        return this.machineRepository.findMachinesByPressureOtherGas(cooling, compressionRatio);
    }

    public Iterable<Machine> searchByPressureNaturalGas(boolean blower, boolean vacuum, String cooling, float minPressure, float maxPressure) {
        return this.machineRepository.findMachinesByPressureBlowerGas(cooling, minPressure, maxPressure);
    }

    public List<Machine> searchByPressureOtherGas(Duty duty) {
        // take the entered duty parameters and extract a list of suitable machines
        // for gas type 'OTHER'
        String cooling = duty.getCoolingType();
        String machine = duty.getMachineType();
        int altitude = duty.getAltitude();
        double inletPressure = duty.getPressureIn();
        double outletPressure = duty.getPressureOut();
        double flowrate = duty.getFlowRate();

        // get barometric pressure at altitude
        double barometricPressure = duty.calculateBarometricPressure();

        inletPressure = (14.5 * inletPressure) + barometricPressure;
        outletPressure = (14.5 * outletPressure) + barometricPressure;
        duty.setCompressionRatio(outletPressure / inletPressure);

        //double adjustedCompressionRation = ( (duty.getCompressionRatio() + barometricPressure) / barometricPressure );

        //Iterable<Machine> list = this.machinesRepository.findMachinesByPressureOtherGas(duty.getCoolingType(), duty.getCompressionRatio());

        Iterable<Machine> list = this.machineRepository.findAll();
        List<Machine> finalList = new ArrayList();
        int maxTipSpeed = 0;
        double pressureToSearch = 3.2;
        double flowToSearch = 406.1392;
        double highSpeed = 0;
        int lowSpeed = 0;
        double lowSpeedFlow = 0;
        double highSpeedFlow = 0;
        for (Machine m : list) {
            if (m.getLubrication().equalsIgnoreCase("OIL")) {
                maxTipSpeed = 3300; // higher speed for oil lubed
            } else {
                maxTipSpeed = 2600;
            }

            for (Flowrate f : m.getFlowrates()) {
                double flowRate = (f.getPressureSquaredCoefficient() * (Math.pow(pressureToSearch, 2)) + (f.getPressureCoefficient() * pressureToSearch) + f.getyAxisIntercept());
                if (flowRate >= flowToSearch) {
                    highSpeed = f.getSpeed();
                    //double whatSpeedPressure = (((flowToSearch - lowSpeedFlow) / (highSpeedFlow - lowSpeedFlow)) * (highSpeed - lowSpeed)) + lowSpeed;
                    double x = m.getOriginal_Displacement() * (highSpeed / m.getOriginal_Displacement_Speed());
                    //double y = 630.0 * (750.0 / 960.0);
                    double tempSpeed = workoutSlipSpeed(m.getOriginal_Displacement() * (highSpeed / m.getOriginal_Displacement_Speed()), 239.046, .938277, highSpeed);
                    double bladeTipSpeed = calculateBladeTipSpeed(tempSpeed, m.getBore());
                    if ((tempSpeed > m.getActual_Min_Speed()) && (bladeTipSpeed < maxTipSpeed)) {
                        if (!finalList.contains(m)) {
                            finalList.add(m);
                            System.out.println(m.getName() + "  Speed=" + f.getSpeed() + "  Temp Speed=" + tempSpeed + "  Flow=" + flowRate + "  Search flow=" + flowToSearch + " Blade Tip Speed=" + bladeTipSpeed);
                        }
                    }
                }
            }
        }
        return finalList;
    }

//    private double calculateBarometricPressure(double altitude) {
//        double temperature = 518.6 - (0.00356 * altitude);
//        double pressure = 14.7 * (Math.pow(temperature / 518.6, 5.256));
//        pressure = Math.round(pressure * 100);
//        return pressure / 100;
//    }

    private double workoutSlipSpeed(double displ, double flowrate, double specificGravity, double displacementSpeed) {
        double slipAir = (displ - flowrate);
        double slipGas = slipAir / (Math.pow(specificGravity, 0.5));
        double FGD = displ - slipGas;
        return (displacementSpeed / FGD) * flowrate;
    }

    private double calculateBladeTipSpeed(double speed, double bore) {
        return ((bore * 3.1415927) / 12) * speed;
    }

    private float convertToStandardPSIA( float value, String unit ) {
        switch (unit) {
            case "psia" : // return the same value, no conversion necessary
                value = value;
                break;
        }
        return value;
    }

    public void saveMachine(Machine machine) {
        machineRepository.save(machine);
    }

}
