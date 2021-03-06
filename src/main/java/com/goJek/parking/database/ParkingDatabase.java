package com.goJek.parking.database;

import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingDatabase {

    private static Map<String, ParkingSpot> parkedVehicleInfo = new HashMap<>();
    private static ParkingFloor parkingFloorInfo = new ParkingFloor();

    public static Map<String,ParkingSpot> getParkedVehicleInfo(){
        return parkedVehicleInfo;
    }

    public static ParkingFloor getParkingFloorInfo(){
        return parkingFloorInfo;
    }
}
