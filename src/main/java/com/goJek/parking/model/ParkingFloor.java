package com.goJek.parking.model;

import java.util.List;


public class ParkingFloor {

    private ParkingSpot[] parkingSpots;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(ParkingSpot[] parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

}
