package com.goJek.parking.service;

import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.List;

public interface ParkingFloorService {

    ParkingFloor createParkingFloor(int noOfSpots);

    ParkingSpot park(String licensePlate,String color);

    ParkingSpot remove(int spotNumber);

    ParkingFloor getStatus();

    List<String> getListOfRegNumberWithColor(String color);

    List<Integer> getListOfSlotsWithCarColor(String color);

    Integer getSlotNumberForRegNumber(String regNumber);
}
