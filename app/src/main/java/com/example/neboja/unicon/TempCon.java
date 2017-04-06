package com.example.neboja.unicon;

/**
 * Created by Nebojša on 2/4/2017.
 */

public class TempCon {
    public  static double c2f(double c){return 32+c*9/5;}
    public static double f2c(double f){return (f-32)*5/9;}

    public static double k2c(double k){return k-273.15;}
    public static double c2k(double c){return c+273.15;}

    public static double f2k(double f){return (f+ 459.67) * 5/9;}
    public static double k2f(double k){return k * 9/5 - 459.67;}
}
