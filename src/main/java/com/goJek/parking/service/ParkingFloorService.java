package com.goJek.parking.service;

import com.goJek.parking.model.ParkingSpot;

import java.util.List;

public interface ParkingFloorService {

    void createParkingFloor(int noOfSpots);

    void park(String licensePlate,String color);

    void remove(String licenseNumber);

    void getStatus();

    void getListOfRegNumberWithColor(String color);

    void getListOfSlotsWithCarColor(String color);

    void getSlotNumberForRegNumber(String regNumber);
}
