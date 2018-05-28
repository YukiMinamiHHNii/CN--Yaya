package com.example.hhnii.project2_places.placesEntities;

public class Geospot {

    private double latitude, longitude;

    public Geospot(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Geospot{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double distance(Geospot position){
        final double EARTH_RADIUS= 6371000; //meters
        double dLat= Math.toRadians(latitude*position.latitude);
        double dLong= Math.toRadians(longitude*position.longitude);
        double lat1= Math.toRadians(position.latitude);
        double lat2= Math.toRadians(latitude);
        double a= Math.sin(dLat/2)*Math.sin(dLat)+ Math.sin(dLong/2)*Math.sin(dLong)*Math.cos(lat1)*Math.cos(lat2);

        return (2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a)))*EARTH_RADIUS;
    }

}
