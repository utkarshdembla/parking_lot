package com.goJek.parking.database;

import com.goJek.parking.model.ParkingFloor;

import java.util.List;

public class ParkingDatabaseHandlerImpl implements ParkingDatabaseHandler {

    private ParkingFloor parkingFloorDB = ParkingDatabase.getParkingFloorInfo();

    @Override
    public void saveParkingFloor(ParkingFloor parkingFloor) {
        parkingFloorDB.setParkingSpots(parkingFloor.getParkingSpots());
        parkingFloorDB.setSize(parkingFloor.getSize());
    }

    public ParkingFloor getParkingFloor(){
        return parkingFloorDB;
    }
}
