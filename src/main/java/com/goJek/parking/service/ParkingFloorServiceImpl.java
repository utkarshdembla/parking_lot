package com.goJek.parking.service;

import com.goJek.parking.database.ParkingDatabase;
import com.goJek.parking.model.Car;
import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.List;
import java.util.Map;

public class ParkingFloorServiceImpl implements ParkingFloorService{

    ParkingFloor parkingFloor = new ParkingFloor();
    UtilityService validationService = new UtilityService();

    ParkingFloorHandler parkingFloorHandler = new ParkingFloorHandlerImpl();

    private static Map<String, ParkingSpot> parkedVehicleInfo = ParkingDatabase.getParkedVehicleInfo();

    @Override
    public ParkingFloor createParkingFloor(int noOfSpots) {
        return parkingFloorHandler.createParkingFloor(noOfSpots);
    }

    @Override
    public ParkingSpot park(String regNumber, String color){
        ParkingSpot parkingSpot = parkingFloorHandler.parkVehicle(regNumber,color);
        return parkingSpot;
    }

    @Override
    public ParkingSpot remove(int spotNumber){
        ParkingSpot parkingSpot = parkingFloorHandler.removeVehicle(spotNumber);
        return parkingSpot;

    }

    @Override
    public ParkingFloor getStatus() {
        return parkingFloorHandler.getStatus();
    }

    @Override
    public List<String> getListOfRegNumberWithColor(String color) {
       return parkingFloorHandler.getListOfRegNumberWithColor(color);
    }

    @Override
    public List<Integer> getListOfSlotsWithCarColor(String color) {
        return parkingFloorHandler.getListOfSlotsWithCarColor(color);
    }

    @Override
    public Integer getSlotNumberForRegNumber(String regNumber) {
        return parkingFloorHandler.getSlotNumberForRegNumber(regNumber);
    }


}
