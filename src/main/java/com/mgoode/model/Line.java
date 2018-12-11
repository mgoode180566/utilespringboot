package com.mgoode.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michaelgoode on 30/05/2017.
 */
@Entity
@Table(name="line")
public class Line implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Machine machine;

    String name;
    String duty;
    int lines;
    int minSpeed;
    int MaxSpeed;

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (id != line.id) return false;
        if (lines != line.lines) return false;
        if (minSpeed != line.minSpeed) return false;
        if (MaxSpeed != line.MaxSpeed) return false;
        if (machine != null ? !machine.equals(line.machine) : line.machine != null) return false;
        if (name != null ? !name.equals(line.name) : line.name != null) return false;
        return duty != null ? duty.equals(line.duty) : line.duty == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (machine != null ? machine.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        result = 31 * result + lines;
        result = 31 * result + minSpeed;
        result = 31 * result + MaxSpeed;
        return result;
    }
}
