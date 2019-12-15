package com.goJek.parking.model;

import java.util.HashMap;
import java.util.List;

public class ParkingFloor {

    private List<ParkingSpot> parkingSpots;

    private HashMap<String,ParkingSpot> parkedVehicleInfo;

    public void createParkingFloor(int noOfSpots){ }

    public void assignVehicleToSpot(Vehicle vehicle){
        // seek in parking spots, if slot is free - give parking-update parkingSpots and parkedvehicleInfo
        //otherwise return Parking is full

    }

    public void removeVehicleFromSpot(String licenseNumber){
        //seek if vehicle is there in parkedVehicleInfo
        //if available-remove the vehicle- update parking spot isFree to false and update parked vehicleInfo
    }

    public List<ParkingSpot> getStatus(){ return parkingSpots;}


}
