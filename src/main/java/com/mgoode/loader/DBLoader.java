package com.mgoode.loader;

import com.mgoode.model.*;
import com.mgoode.service.GasService;
import com.mgoode.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by michaelgoode on 15/03/2017.
 */
@Component
public class DBLoader implements ApplicationRunner {

    private GasService gasService;
    private MachineService machineService;

    @Autowired
    public DBLoader(GasService gasService, MachineService machineService) {
        this.gasService = gasService;
        this.machineService = machineService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        //saveMachine();

//        readGasCSV("C:\\Users\\michaelgoode\\Documents\\Utile Engineering\\DB\\Gases.csv");
//        ArrayList<Machine> machines = readMachineCSV("C:\\Users\\michaelgoode\\Documents\\Utile Engineering\\DB\\MachineDetails.csv");
//        ArrayList<Line> lines = readLinesCSV("C:\\Users\\michaelgoode\\Documents\\Utile Engineering\\DB\\Lines.csv");
//        ArrayList<Flowrate> flowrates = readFlowrateCSV("C:\\Users\\michaelgoode\\Documents\\Utile Engineering\\DB\\Flowrates.csv");
//        ArrayList<SurfaceTemperature> temperatures = readSurfaceTemperatureCSV("C:\\Users\\michaelgoode\\Documents\\Utile Engineering\\DB\\SurfaceTemperatures.csv");
//        merge(machines,lines,flowrates,temperatures);
    }

    private void merge(ArrayList<Machine> machines, ArrayList<Line> lines, ArrayList<Flowrate> flowrates, ArrayList<SurfaceTemperature> surfacetemps) {
        Iterator lineIter = lines.iterator();
        while (lineIter.hasNext()) {
            Line aLine = (Line) lineIter.next();
            Machine test = new Machine();
            test.setName(aLine.getName());
            if (machines.contains(test)) {
                int idx = machines.indexOf(test);
                Machine aMachine = machines.get(idx);
                aMachine.getLines().add(aLine);
                aLine.setMachine(aMachine);
                //machinesRepository.save(aMachine);
            } else {
                int x = 0;
            }
        }

        Iterator flowIter = flowrates.iterator();
        while (flowIter.hasNext()) {
            Flowrate flowrate = (Flowrate) flowIter.next();
            Machine test = new Machine();
            test.setName(flowrate.getName());
            if (machines.contains(test)) {
                int idx = machines.indexOf(test);
                Machine aMachine = machines.get(idx);
                aMachine.getFlowrates().add(flowrate);
                flowrate.setMachine(aMachine);
            } else {
                int x = 0;
            }
        }

        Iterator surfaceIter = surfacetemps.iterator();
        while (surfaceIter.hasNext()) {
            SurfaceTemperature surfaceTemperature = (SurfaceTemperature) surfaceIter.next();
            Machine test = new Machine();
            test.setName(surfaceTemperature.getName());
            if (machines.contains(test)) {
                int idx = machines.indexOf(test);
                Machine aMachine = machines.get(idx);
                surfaceTemperature.setMachine(aMachine);
                aMachine.getSurfaceTemperatures().add(surfaceTemperature);
            } else {
                int x = 0;
            }
        }

        Iterator machineIter = machines.iterator();
        while (machineIter.hasNext()) {
            Machine machine = (Machine) machineIter.next();
            //machineService.saveMachine(machine);
        }
    }

    private void readGasCSV( String filename ) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] gasrec = line.split(cvsSplitBy);
                gasService.save(new Gas(gasrec[0],gasrec[1],gasrec[2],gasrec[3],gasrec[4],gasrec[5],gasrec[6],gasrec[26]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ArrayList<Machine> readMachineCSV( String filename ) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Machine> machines = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] machinerec = line.split(cvsSplitBy);
                Machine aMachine = new Machine();
                aMachine.setName(machinerec[0]);
                aMachine.setMin_Speed(Integer.parseInt(machinerec[1]));
                aMachine.setMax_Speed(Integer.parseInt(machinerec[2]));
                aMachine.setActual_Min_Speed(Integer.parseInt(machinerec[3]));
                aMachine.setActual_Max_Speed(Integer.parseInt(machinerec[4]));
                aMachine.setMin_Pressure(Integer.parseInt(machinerec[5]));
                aMachine.setMax_Pressure(Integer.parseInt(machinerec[6]));
                if (machinerec[7].equalsIgnoreCase("VRAI")) {
                    aMachine.setVacuum(true);
                } else aMachine.setVacuum(false);
                if (machinerec[8].equalsIgnoreCase("VRAI")) {
                    aMachine.setBlower(true);
                } else aMachine.setBlower(false);
                if (machinerec[9].equalsIgnoreCase("VRAI")) {
                    aMachine.setDry_Nat_Gas(true);
                } else aMachine.setDry_Nat_Gas(false);
                if (machinerec[10].equalsIgnoreCase("VRAI")) {
                    aMachine.setOther_Gas(true);
                } else aMachine.setOther_Gas(false);

                //aMachine.setMaxTemp(Integer.parseInt(machinerec[11]));
                aMachine.setLubrication(machinerec[12]);
                aMachine.setBore(Float.parseFloat(machinerec[13]));
                aMachine.setCurrent_Outle_Port_Angle(Integer.parseInt(machinerec[14]));
                aMachine.setCurrent_Inlet_Port_Angle(Integer.parseInt(machinerec[15]));
                aMachine.setNumber_Of_Blades(Integer.parseInt(machinerec[16]));
                aMachine.setBlade_Thickness(Float.parseFloat(machinerec[17]));
                aMachine.setCylinder_Diameter(Float.parseFloat(machinerec[18]));
                aMachine.setRotor_Diameter(Float.parseFloat(machinerec[19]));
                aMachine.setCylinder_Length(Float.parseFloat(machinerec[20]));
                aMachine.setOriginal_Displacement(Integer.parseInt(machinerec[21]));
                aMachine.setOriginal_Displacement_Speed(Integer.parseInt(machinerec[22]));
                aMachine.setLubrication_Dome(Float.parseFloat(machinerec[23]));
                aMachine.setLubrication8020(Float.parseFloat(machinerec[24]));
                aMachine.setLubricationTK(Float.parseFloat(machinerec[25]));
                aMachine.setLubrication_Original_Speed(Integer.parseInt(machinerec[26]));
                if (machinerec[27].contains("Air")) {
                    aMachine.setCooling("Air");
                } else aMachine.setCooling("Water");

                aMachine.setLubrication_Points(Integer.parseInt(machinerec[28]));
                machineService.saveMachine(aMachine);
            }
            return machines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                    return machines;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    private ArrayList<Line> readLinesCSV( String filename ) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Line> lines = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] linerec = line.split(cvsSplitBy);
                Line aline = new Line();
                aline.setName(linerec[0]);
                aline.setDuty(linerec[1]);
                aline.setLines(Integer.parseInt(linerec[2]));
                aline.setMinSpeed(Integer.parseInt(linerec[3]));
                aline.setMaxSpeed(Integer.parseInt(linerec[4]));
                lines.add(aline);
            }
            return lines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                    return lines;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    private ArrayList<Flowrate> readFlowrateCSV( String filename ) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Flowrate> flowrates = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] linerec = line.split(cvsSplitBy);
                Flowrate aFlowrate = new Flowrate();
                aFlowrate.setName(linerec[0]);
                aFlowrate.setDuty(linerec[1]);
                aFlowrate.setSpeed(Integer.parseInt(linerec[2]));
                aFlowrate.setPressureSquaredCoefficient(Float.parseFloat(linerec[3]));
                aFlowrate.setPressureCoefficient(Float.parseFloat(linerec[4]));
                aFlowrate.setyAxisIntercept(Float.parseFloat(linerec[5]));
                aFlowrate.setConfidence(Integer.parseInt(linerec[6]));
                if (linerec[7].equalsIgnoreCase("FAUX")) {
                    aFlowrate.setTested(false);
                } else aFlowrate.setTested(true);
                flowrates.add(aFlowrate);
            }
            return flowrates;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                    return flowrates;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }



    private ArrayList<SurfaceTemperature> readSurfaceTemperatureCSV( String filename ) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<SurfaceTemperature> flowrates = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] linerec = line.split(cvsSplitBy);
                SurfaceTemperature aFlowrate = new SurfaceTemperature();
                aFlowrate.setName(linerec[0]);
                aFlowrate.setDuty(linerec[1]);
                aFlowrate.setSpeed(Integer.parseInt(linerec[2]));
                aFlowrate.setPressureCoefficient(Float.parseFloat(linerec[3]));
                aFlowrate.setyAxisIntercept(Float.parseFloat(linerec[4]));
                aFlowrate.setConfidence(Integer.parseInt(linerec[5]));
                if (linerec[6].equalsIgnoreCase("FAUX")) {
                    aFlowrate.setTested(false);
                } else aFlowrate.setTested(true);
                flowrates.add(aFlowrate);
            }
            return flowrates;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                    return flowrates;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }




    public void saveMachine() {
        Machine machine = new Machine();
        machine.setName("A machine");
        Line line = new Line();
        line.setName("A line");
        line.setMachine(machine);
        machine.getLines().add(line);

        //machineService.add(machine);
    }
}
