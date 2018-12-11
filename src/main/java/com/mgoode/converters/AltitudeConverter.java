package com.mgoode.converters;

/**
 * Created by michaelgoode on 05/06/2017.
 */

public class AltitudeConverter extends UnitConvert {

    final private double METRES_TO_FEET = 3.281;

    double factor;

    public AltitudeConverter( String unit ) {
        if (unit.equalsIgnoreCase("masl")) {
            factor = METRES_TO_FEET;
        }
    }

    // convert metres above sea level to feet above sea level
    @Override
    public double toImperial( double altitude ) {
        return altitude * factor;
    }
}
