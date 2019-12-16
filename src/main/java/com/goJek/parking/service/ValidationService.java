package com.goJek.parking.service;

import com.goJek.parking.model.ParkingSpot;
import java.util.Map;

public class ValidationService {

    public boolean ifVehicleAlreadyPresentInParkingLot(String licenseNumber, Map<String, ParkingSpot> parkedVehicleInfo){
        if(licenseNumber.isEmpty()){
            System.out.println("Error:: License Number of the vehicle cannot be empty");
            return false;
        }
        else{
            if(parkedVehicleInfo.get(licenseNumber)!=null) {
                System.out.println("Vehicle already parked in parking lot");
                return true;
            }
            return false;
        }

    }

}
