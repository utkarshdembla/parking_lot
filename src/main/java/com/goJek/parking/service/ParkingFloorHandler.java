package com.goJek.parking.service;

import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;
import com.goJek.parking.model.Vehicle;

import java.util.List;

public interface ParkingFloorHandler {

    ParkingFloor createParkingFloor(Integer size);

    ParkingSpot parkVehicle(String regNumber, String color);

    ParkingSpot removeVehicle(Integer regNumber);

    ParkingFloor getStatus();

    List<String> getListOfRegNumberWithColor(String color);

    List<Integer> getListOfSlotsWithCarColor(String color);

    Integer getSlotNumberForRegNumber(String regNumber);
}
