package com.goJek.parking.service;

import com.goJek.parking.database.ParkingDatabase;
import com.goJek.parking.model.Car;
import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.List;
import java.util.Map;

public class ParkingFloorServiceImplementation implements ParkingFloorService{

    ParkingFloor parkingFloor = new ParkingFloor();
    ValidationService validationService = new ValidationService();

    private static Map<String, ParkingSpot> parkedVehicleInfo = ParkingDatabase.getParkedVehicleInfo();

    @Override
    public void createParkingFloor(int noOfSpots) {
        ParkingSpot[] parkingSpots = new ParkingSpot[noOfSpots];

        for(int i=0;i<parkingSpots.length;i++){
            parkingSpots[i]= new ParkingSpot();
            parkingSpots[i].setSpotNumber(i+1);
            parkingSpots[i].setIfFree(true);
        }

        parkingFloor.setSize(noOfSpots);
        parkingFloor.setParkingSpots(parkingSpots);
        System.out.println("Created parking floor with "+noOfSpots+" slots");
    }

    @Override
    public void park(String licensePlate, String color){
        ParkingSpot[] parkingSpots = parkingFloor.getParkingSpots();

        if(validationService.ifVehicleAlreadyPresentInParkingLot(licensePlate,parkedVehicleInfo))
            return;

        boolean assigned = false;
        if(parkingSpots!=null){
            for(int i=0;i<parkingSpots.length;i++) {
                if(parkingSpots[i].isIfFree()) {
                    parkingSpots[i].setVehicle(new Car(licensePlate,color));
                    parkingSpots[i].setIfFree(false);
                    System.out.println("Allocated slot number : " + parkingSpots[i].getSpotNumber());
                    parkedVehicleInfo.put(licensePlate, parkingSpots[i]);
                    assigned=true;
                    break;
                }
            }
        }
        if(!assigned)
            System.out.println("Parking lot is full");
        parkingFloor.setParkingSpots(parkingSpots);
    }

    @Override
    public void remove(String licenseNumber){

        if(!validationService.ifVehicleAlreadyPresentInParkingLot(licenseNumber,parkedVehicleInfo))
            return;

            ParkingSpot parkingSpot = parkedVehicleInfo.get(licenseNumber);
            int spotNumber = parkingSpot.getSpotNumber();
            ParkingSpot[] parkingSpots = parkingFloor.getParkingSpots();
            parkingSpots[spotNumber-1].setVehicle(null);
            parkingSpots[spotNumber-1].setIfFree(true);
            parkedVehicleInfo.remove(licenseNumber);
            System.out.println("Spot number "+spotNumber+" is free");

    }

    @Override
    public void getStatus() {
        ParkingSpot[] parkingSpots = parkingFloor.getParkingSpots();

        for(int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i].getVehicle() != null) {
                System.out.println(parkingSpots[i].getSpotNumber() + "--" + parkingSpots[i].getVehicle().getLicensePlate() + "--" + parkingSpots[i].getVehicle().getColor());
            }
        }
    }

    @Override
    public void getListOfRegNumberWithColor(String color) {
        ParkingSpot[] parkingSpots = parkingFloor.getParkingSpots();

        if(color.isEmpty()){
            System.out.println("Color cannot be empty");
            return;
        }


        for(ParkingSpot parkingSpot:parkingSpots){
            if(parkingSpot.getVehicle()!=null && parkingSpot.getVehicle().getColor().equalsIgnoreCase(color)){
                System.out.println(parkingSpot.getVehicle().getLicensePlate());
            }
        }

    }

    @Override
    public void getListOfSlotsWithCarColor(String color) {

        if(color.isEmpty()){
            System.out.println("Color cannot be empty");
            return;
        }

        ParkingSpot[] parkingSpots = parkingFloor.getParkingSpots();

        for(ParkingSpot parkingSpot:parkingSpots){
            if(parkingSpot.getVehicle()!=null && parkingSpot.getVehicle().getColor().equalsIgnoreCase(color)){
                System.out.println(parkingSpot.getSpotNumber());
            }
        }
    }

    @Override
    public void getSlotNumberForRegNumber(String regNumber) {

        if(regNumber.isEmpty()){
            System.out.println("Registration number cannot be empty");
            return;
        }

        ParkingSpot parkingSpot = parkedVehicleInfo.get(regNumber);

        if(parkingSpot!=null)
            System.out.println(parkingSpot.getSpotNumber());
        else
            System.out.println("Vehicle not available in parking spot");

    }


}
