package com.goJek.parking.database;

import com.goJek.parking.model.ParkingSpot;
import com.goJek.parking.model.Vehicle;

import java.util.Map;

public interface VehicleDatabaseHandler {

    void saveVehicleInSpot(String regNo, ParkingSpot parkingSpot);

    ParkingSpot getParkingSpotForVehicle(String regNo);

    Map<String, ParkingSpot> getParkedVehicleInfo();
}
