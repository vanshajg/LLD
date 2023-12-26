package com.vanshajgirotra.problems.parking.lot.utilities;

public class IntegerValidator {
    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
