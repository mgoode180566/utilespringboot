package com.mgoode.converters;

/**
 * Created by michaelgoode on 05/06/2017.
 */
public class WaterFlowRate extends UnitConvert{

    private final double GALLONS_TO_GALLONS = 1;
    private final double LITRES_TO_GALLON = 4.546;

    public WaterFlowRate( String unit ) {

        if (unit.equalsIgnoreCase("gpm")) {
            factor = GALLONS_TO_GALLONS;
        } else if (unit.equalsIgnoreCase("litresmin")) {
            factor = LITRES_TO_GALLON;
        } else if (unit.equalsIgnoreCase("litressec")) {
            factor = LITRES_TO_GALLON / 60;
        }

    }

    @Override
    public double toImperial(double value) {
        return value * factor;
    }
}
