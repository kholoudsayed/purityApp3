package com.example.kholoud.app;

/**
 * Created by kholoud on 10/21/2019.
 */

public class LocationHelper {


    private double Longitude;
    private double Latitude;

    public LocationHelper(double latitude ,double longitude) {
        Latitude = latitude;
        Longitude =longitude;
    }



    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }
}
