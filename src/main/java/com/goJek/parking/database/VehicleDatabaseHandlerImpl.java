package com.goJek.parking.database;

import com.goJek.parking.model.ParkingSpot;

import java.util.Map;

public class VehicleDatabaseHandlerImpl implements VehicleDatabaseHandler {

    private static Map<String, ParkingSpot> parkedVehicleInfo = ParkingDatabase.getParkedVehicleInfo();

    @Override
    public void saveVehicleInSpot(String regNo, ParkingSpot parkingSpot) {
        parkedVehicleInfo.put(regNo,parkingSpot);
    }

    public ParkingSpot getParkingSpotForVehicle(String regNo){
        return parkedVehicleInfo.get(regNo);
    }

    public Map<String, ParkingSpot> getParkedVehicleInfo(){
        return parkedVehicleInfo;
    }
}
