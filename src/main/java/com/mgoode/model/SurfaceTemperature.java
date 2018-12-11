package com.mgoode.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michaelgoode on 31/05/2017.
 */
@Entity
@Table (name="SurfaceTemperature")
public class SurfaceTemperature implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    Machine machine;

    String name;
    String duty;
    int speed;
    float pressureCoefficient;
    float yAxisIntercept;
    int confidence;
    boolean tested;


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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getPressureCoefficient() {
        return pressureCoefficient;
    }

    public void setPressureCoefficient(float pressureCoefficient) {
        this.pressureCoefficient = pressureCoefficient;
    }

    public float getyAxisIntercept() {
        return yAxisIntercept;
    }

    public void setyAxisIntercept(float yAxisIntercept) {
        this.yAxisIntercept = yAxisIntercept;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }
}
