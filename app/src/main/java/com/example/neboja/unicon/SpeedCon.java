package com.example.neboja.unicon;

/**
 * Created by Nebojša on 3/4/2017.
 */

public class SpeedCon {
    public  static double kph2mph(double kph){return kph/1.609344;}
    public static double mph2kph(double mph){return mph*1.609344;}

    public static double kph2mps(double kph){return kph*0.27777777777778 ;}
    public static double mps2kph(double mps){return mps/0.27777777777778;}

    public static double mph2mps(double mph){return mph*0.44704  ;}
    public static double mps2mph(double mps){return mps/0.44704 ;}
}

