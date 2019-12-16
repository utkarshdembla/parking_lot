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

    public ParkingSpot(){}

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isIfFree() {
        return ifFree;
    }

    public void setIfFree(boolean ifFree) {
        this.ifFree = ifFree;
    }
}
