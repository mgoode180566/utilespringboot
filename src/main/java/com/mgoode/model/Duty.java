package com.mgoode.model;

/**
 * Created by michaelgoode on 23/06/2017.
 */
public class Duty {

    String machineType;
    String coolingType;
    String searchType;
    double flowRate;
    double pressureIn;
    double pressureOut;
    double inletTemp;
    int altitude;
    double barometricPressure;
    double compressionRatio;

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(float flowRate) {
        this.flowRate = flowRate;
    }

    public double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(float pressureIn) {
        this.pressureIn = pressureIn;
    }

    public double getPressureOut() {
        return pressureOut;
    }

    public void setPressureOut(float pressureOut) {
        this.pressureOut = pressureOut;
    }

    public double getInletTemp() {
        return inletTemp;
    }

    public void setInletTemp(double inletTemp) {
        this.inletTemp = inletTemp;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public double getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(double barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public double calculateBarometricPressure() {
        double temperature = 518.6 - (0.00356 * altitude);
        double pressure = 14.7 * (Math.pow(temperature / 518.6, 5.256));
        pressure = Math.round(pressure * 100);
        barometricPressure = pressure / 100;
        return barometricPressure;
    }
}
