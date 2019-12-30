package com.goJek.parking.service;

import com.goJek.parking.database.ParkingDatabaseHandler;
import com.goJek.parking.database.ParkingDatabaseHandlerImpl;
import com.goJek.parking.database.VehicleDatabaseHandler;
import com.goJek.parking.database.VehicleDatabaseHandlerImpl;
import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.List;
import java.util.Map;

public class UtilityService {

    ParkingDatabaseHandler parkingDatabaseHandler = new ParkingDatabaseHandlerImpl();
    VehicleDatabaseHandler vehicleDatabaseHandler = new VehicleDatabaseHandlerImpl();

    public boolean ifVehicleAlreadyPresentInParkingLot(String licenseNumber){
        if(licenseNumber.isEmpty()){
            System.out.println("Error:: License Number of the vehicle cannot be empty");
            return false;
        }
        else{
            if(vehicleDatabaseHandler.getParkedVehicleInfo().get(licenseNumber)!=null) {
                System.out.println("Vehicle already parked in parking lot");
                return true;
            }
            return false;
        }

    }

    public ParkingSpot getNearestparkingSpot(){

        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();

            if(parkingFloor!=null) {
                for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                    if (parkingSpot.isIfFree())
                        return parkingSpot;
                }
            }
        return null;
    }

    public boolean ifParkingIsFree(){
        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();

        if(parkingFloor!=null) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.isIfFree())
                    return true;
            }
        }
        return false;
    }

}
