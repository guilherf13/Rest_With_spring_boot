package com.example.demo.convert.number;

public class ConvertNumber {

    public static Double convertDouble(String number){
        if(number == null) return 1D;

        String strNumber = number.replace(".", ",");

        if(isNumber(strNumber)) return Double.parseDouble(strNumber);
        return 0D;
    }

    public static boolean isNumber(String number) {
        if(number == null) return false;
        String strNumber = number.replace(".", ",");
        return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
