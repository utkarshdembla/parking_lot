package com.goJek.parking.model;

public class ParkingSpot {

    private int spotNumber;
    private Vehicle vehicle;
    private boolean ifFree;

    public ParkingSpot(int spotNumber,Vehicle vehicle,boolean ifFree){
        this.spotNumber = spotNumber;
        this.vehicle = vehicle;
        this.ifFree = ifFree;
    }

    public boolean ifSpotAvailable(){
        return ifFree;
    }
}
