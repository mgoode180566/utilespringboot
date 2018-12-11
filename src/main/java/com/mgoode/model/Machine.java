package com.mgoode.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by michaelgoode on 08/11/2016.
 */

@Entity
@Table(name="machine")
public class Machine implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Column(name="name")
    String name;

    @OneToMany(mappedBy="machine",cascade = CascadeType.ALL)
    Collection<Line> lines;

    @OneToMany(mappedBy="machine",cascade = CascadeType.ALL)
    Collection<Flowrate> flowrates;

    @OneToMany(mappedBy="machine",cascade = CascadeType.ALL)
    Collection<SurfaceTemperature> surfaceTemperatures;

    public Machine() {
        lines = new ArrayList<>();
        flowrates = new ArrayList<>();
        surfaceTemperatures = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Line> getLines() {
        return lines;
    }

    public void setLines(Collection<Line> lines) {
        this.lines = lines;
    }

    public Collection<Flowrate> getFlowrates() {
        return flowrates;
    }

    public void setFlowrates(Collection<Flowrate> flowrates) {
        this.flowrates = flowrates;
    }

    public Collection<SurfaceTemperature> getSurfaceTemperatures() {
        return surfaceTemperatures;
    }

    public void setSurfaceTemperatures(Collection<SurfaceTemperature> surfaceTemperatures) {
        this.surfaceTemperatures = surfaceTemperatures;
    }

    public Machine(String name ) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Machine machine = (Machine) o;

        return name.equals(machine.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


    int min_Speed;
    int max_Speed;
    int actual_Min_Speed;
    int actual_Max_Speed;
    double min_Pressure;
    double max_Pressure;
    boolean vacuum;
    boolean blower;
    boolean dry_Nat_Gas;
    boolean other_Gas;
    int max_Temp;
    String lubrication;
    double bore;
    int current_Outle_Port_Angle;
    int current_Inlet_Port_Angle;
    int number_Of_Blades;
    double blade_Thickness;
    double cylinder_Diameter;
    double rotor_Diameter;
    double cylinder_Length;
    int original_Displacement;
    int original_Displacement_Speed;
    double lubrication_Dome;
    double lubrication8020;
    double lubricationTK;
    int lubrication_Original_Speed;
    String cooling;
    int lubrication_Points;

    public int getMin_Speed() {
        return min_Speed;
    }

    public void setMin_Speed(int min_Speed) {
        this.min_Speed = min_Speed;
    }

    public int getMax_Speed() {
        return max_Speed;
    }

    public void setMax_Speed(int max_Speed) {
        this.max_Speed = max_Speed;
    }

    public int getActual_Min_Speed() {
        return actual_Min_Speed;
    }

    public void setActual_Min_Speed(int actual_Min_Speed) {
        this.actual_Min_Speed = actual_Min_Speed;
    }

    public int getActual_Max_Speed() {
        return actual_Max_Speed;
    }

    public void setActual_Max_Speed(int actual_Max_Speed) {
        this.actual_Max_Speed = actual_Max_Speed;
    }

    public double getMin_Pressure() {
        return min_Pressure;
    }

    public void setMin_Pressure(double min_Pressure) {
        this.min_Pressure = min_Pressure;
    }

    public double getMax_Pressure() {
        return max_Pressure;
    }

    public void setMax_Pressure(double max_Pressure) {
        this.max_Pressure = max_Pressure;
    }

    public boolean isVacuum() {
        return vacuum;
    }

    public void setVacuum(boolean vacuum) {
        this.vacuum = vacuum;
    }

    public boolean isBlower() {
        return blower;
    }

    public void setBlower(boolean blower) {
        this.blower = blower;
    }

    public boolean isDry_Nat_Gas() {
        return dry_Nat_Gas;
    }

    public void setDry_Nat_Gas(boolean dry_Nat_Gas) {
        this.dry_Nat_Gas = dry_Nat_Gas;
    }

    public boolean isOther_Gas() {
        return other_Gas;
    }

    public void setOther_Gas(boolean other_Gas) {
        this.other_Gas = other_Gas;
    }

    public int getMax_Temp() {
        return max_Temp;
    }

    public void setMax_Temp(int max_Temp) {
        this.max_Temp = max_Temp;
    }

    public String getLubrication() {
        return lubrication;
    }

    public void setLubrication(String lubrication) {
        this.lubrication = lubrication;
    }

    public double getBore() {
        return bore;
    }

    public void setBore(double bore) {
        this.bore = bore;
    }

    public int getCurrent_Outle_Port_Angle() {
        return current_Outle_Port_Angle;
    }

    public void setCurrent_Outle_Port_Angle(int current_Outle_Port_Angle) {
        this.current_Outle_Port_Angle = current_Outle_Port_Angle;
    }

    public int getCurrent_Inlet_Port_Angle() {
        return current_Inlet_Port_Angle;
    }

    public void setCurrent_Inlet_Port_Angle(int current_Inlet_Port_Angle) {
        this.current_Inlet_Port_Angle = current_Inlet_Port_Angle;
    }

    public int getNumber_Of_Blades() {
        return number_Of_Blades;
    }

    public void setNumber_Of_Blades(int number_Of_Blades) {
        this.number_Of_Blades = number_Of_Blades;
    }

    public double getBlade_Thickness() {
        return blade_Thickness;
    }

    public void setBlade_Thickness(double blade_Thickness) {
        this.blade_Thickness = blade_Thickness;
    }

    public double getCylinder_Diameter() {
        return cylinder_Diameter;
    }

    public void setCylinder_Diameter(double cylinder_Diameter) {
        this.cylinder_Diameter = cylinder_Diameter;
    }

    public double getRotor_Diameter() {
        return rotor_Diameter;
    }

    public void setRotor_Diameter(double rotor_Diameter) {
        this.rotor_Diameter = rotor_Diameter;
    }

    public double getCylinder_Length() {
        return cylinder_Length;
    }

    public void setCylinder_Length(double cylinder_Length) {
        this.cylinder_Length = cylinder_Length;
    }

    public int getOriginal_Displacement() {
        return original_Displacement;
    }

    public void setOriginal_Displacement(int original_Displacement) {
        this.original_Displacement = original_Displacement;
    }

    public int getOriginal_Displacement_Speed() {
        return original_Displacement_Speed;
    }

    public void setOriginal_Displacement_Speed(int original_Displacement_Speed) {
        this.original_Displacement_Speed = original_Displacement_Speed;
    }

    public double getLubrication_Dome() {
        return lubrication_Dome;
    }

    public void setLubrication_Dome(double lubrication_Dome) {
        this.lubrication_Dome = lubrication_Dome;
    }

    public double getLubrication8020() {
        return lubrication8020;
    }

    public void setLubrication8020(double lubrication8020) {
        this.lubrication8020 = lubrication8020;
    }

    public double getLubricationTK() {
        return lubricationTK;
    }

    public void setLubricationTK(double lubricationTK) {
        this.lubricationTK = lubricationTK;
    }

    public int getLubrication_Original_Speed() {
        return lubrication_Original_Speed;
    }

    public void setLubrication_Original_Speed(int lubrication_Original_Speed) {
        this.lubrication_Original_Speed = lubrication_Original_Speed;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public int getLubrication_Points() {
        return lubrication_Points;
    }

    public void setLubrication_Points(int lubrication_Points) {
        this.lubrication_Points = lubrication_Points;
    }
}
