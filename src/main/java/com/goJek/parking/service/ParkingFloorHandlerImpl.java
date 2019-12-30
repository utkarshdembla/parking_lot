package com.goJek.parking.service;

import com.goJek.parking.database.ParkingDatabaseHandler;
import com.goJek.parking.database.ParkingDatabaseHandlerImpl;
import com.goJek.parking.database.VehicleDatabaseHandler;
import com.goJek.parking.database.VehicleDatabaseHandlerImpl;
import com.goJek.parking.model.Car;
import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloorHandlerImpl implements ParkingFloorHandler {

    private ParkingDatabaseHandler parkingDatabaseHandler = new ParkingDatabaseHandlerImpl();
    private VehicleDatabaseHandler vehicleDatabaseHandler = new VehicleDatabaseHandlerImpl();
    private UtilityService utilityService = new UtilityService();

    @Override
    public ParkingFloor createParkingFloor(Integer size) {
        if(size==null)
            return null;
        ParkingFloor parkingFloor = new ParkingFloor();
        ParkingSpot[] parkingSpots = new ParkingSpot[size];

        for(int i=0;i<size;i++){
            parkingSpots[i] = new ParkingSpot(i+1,true);
        }

        parkingFloor.setSize(size);
        parkingFloor.setParkingSpots(parkingSpots);
        parkingDatabaseHandler.saveParkingFloor(parkingFloor);
        return parkingFloor;
    }

    @Override
    public ParkingSpot parkVehicle(String regNumber, String color) {
        if (regNumber == null || color == null)
            return null;

        if(utilityService.ifVehicleAlreadyPresentInParkingLot(regNumber))
            return null;

        if(!utilityService.ifParkingIsFree())
            return null;

       ParkingSpot parkingSpot = utilityService.getNearestparkingSpot();

       if(parkingSpot!=null){
           parkingSpot.setVehicle(new Car(regNumber,color));
           parkingSpot.setIfFree(false);
       }

       saveParkingSpotOnFloor(parkingSpot);
       saveVehicleInSpot(regNumber,parkingSpot);
       return parkingSpot;

    }

    @Override
    public ParkingSpot removeVehicle(Integer spotNumber) {

        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();
        ParkingSpot parkingSpot = parkingFloor.getParkingSpots()[spotNumber-1];
        vehicleDatabaseHandler.getParkedVehicleInfo().remove(parkingSpot.getVehicle().getLicensePlate());
        parkingSpot.setVehicle(null);
        parkingSpot.setIfFree(true);
        saveParkingSpotOnFloor(parkingSpot);
        return parkingSpot;
    }

    @Override
    public ParkingFloor getStatus() {
        return parkingDatabaseHandler.getParkingFloor();
    }

    @Override
    public List<String> getListOfRegNumberWithColor(String color) {
        List<String> listOfRegNumber = new ArrayList<>();
        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();

        for(ParkingSpot value:parkingFloor.getParkingSpots()){
            if(value.getVehicle()!=null && value.getVehicle().getColor().equalsIgnoreCase(color)){
                listOfRegNumber.add(value.getVehicle().getLicensePlate());
            }
        }
        return listOfRegNumber;
    }

    @Override
    public List<Integer> getListOfSlotsWithCarColor(String color) {
        List<Integer> listOfSlots = new ArrayList<>();
        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();

        for(ParkingSpot value:parkingFloor.getParkingSpots()){
            if(value.getVehicle()!=null && value.getVehicle().getColor().equalsIgnoreCase(color)){
                listOfSlots.add(value.getSpotNumber());
            }
        }
        return listOfSlots;
    }

    @Override
    public Integer getSlotNumberForRegNumber(String regNumber) {
        Integer slotNumber = null;
        ParkingSpot parkingSpot = vehicleDatabaseHandler.getParkedVehicleInfo().get(regNumber);
        if(parkingSpot!=null)
            slotNumber=parkingSpot.getSpotNumber();
        return slotNumber;
    }

    private void saveParkingSpotOnFloor(ParkingSpot parkingSpot){

        ParkingFloor parkingFloor = parkingDatabaseHandler.getParkingFloor();
        ParkingSpot[] parkingSpotsOnFloor = parkingFloor.getParkingSpots();
        parkingSpotsOnFloor[parkingSpot.getSpotNumber()-1]=parkingSpot;
        parkingFloor.setParkingSpots(parkingSpotsOnFloor);
        parkingDatabaseHandler.saveParkingFloor(parkingFloor);
    }

    private void saveVehicleInSpot(String regNumber,ParkingSpot parkingSpot){
        vehicleDatabaseHandler.saveVehicleInSpot(regNumber,parkingSpot);
    }


}
