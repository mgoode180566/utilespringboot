package com.mgoode.converters;

/**
 * Created by michaelgoode on 06/06/2017.
 */
public class LubricationVolume extends UnitConvert {

    private final double LITRES_TO_GALLON = 4.546;
    private final double GALLON_TO_GALLON = 1;

    public LubricationVolume(String unit) {
        if (unit.equalsIgnoreCase("hrgallon")) {
            factor = GALLON_TO_GALLON;
        } else if (unit.equalsIgnoreCase("litrehr")) {
            factor = LITRES_TO_GALLON;
        } else if (unit.equalsIgnoreCase("litreday")) {

        } else if (unit.equalsIgnoreCase("gallonhr")) {

        } else if (unit.equalsIgnoreCase("gallonday")) {

        }
    }

    @Override
    public double toImperial(double value) {
        return value * factor;
    }


}
