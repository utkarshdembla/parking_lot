package com.goJek.parking.service;
import com.goJek.parking.config.Constant;
import com.goJek.parking.model.ParkingFloor;
import com.goJek.parking.model.ParkingSpot;

import java.util.Iterator;
import java.util.List;

public class InputHandler {

    ParkingFloorService parkingFloorService = new ParkingFloorServiceImpl();
    UtilityService utilityService = new UtilityService();

    public void inputCommandService(String command,String[] values) {
        ParkingSpot parkingSpot;
        if (command != null) {
            switch (command.toLowerCase()) {
                case Constant.createParkingLot:

                    ParkingFloor parkingFloor = parkingFloorService.createParkingFloor(Integer.valueOf(values[0]));
                    System.out.println("Created a parking lot with "+parkingFloor.getSize()+" slots");
                    break;


                case Constant.leave:

                    if (values[0] == null) {
                        System.out.println("Spot Number cannot be null");
                        break;
                    }

                    parkingSpot = parkingFloorService.remove(Integer.valueOf(values[0]));

                    if(parkingSpot!=null && parkingSpot.getVehicle()!=null)
                    System.out.println("Slot number "+parkingSpot.getSpotNumber()+" is free");
                    break;


                case Constant.park:
                    if (values[0] == null || values[1] == null) {
                        System.out.println("RegNo or color values cannot be null");
                        break;
                    }

                    if(utilityService.ifVehicleAlreadyPresentInParkingLot(values[0])) {
                        System.out.println("Vehicle already present in parking Lot");
                        break;
                    }

                    if(!utilityService.ifParkingIsFree()) {
                        System.out.println("Sorry, parking lot is  full");
                        break;
                    }

                    parkingSpot = parkingFloorService.park(values[0],values[1]);
                    if(parkingSpot!=null)
                    System.out.println("Allocated slot number: "+parkingSpot.getSpotNumber());
                    break;


                case Constant.status:


                    parkingFloor = parkingFloorService.getStatus();
                    System.out.println("Slot No.  Registration No    Colour");
                    for(ParkingSpot value:parkingFloor.getParkingSpots()){
                        if(value!=null && value.getVehicle()!=null)
                            System.out.println(value.getSpotNumber()+"         "+
                                               value.getVehicle().getLicensePlate()+"      "+
                                               value.getVehicle().getColor());
                    }

                    break;



                case Constant.registrationNumbersForCarsWithColor:


                    List<String> listOfRegNumber = parkingFloorService.getListOfRegNumberWithColor(values[0]);
                    Iterator itrRegNumber = listOfRegNumber.iterator();
                    while (itrRegNumber.hasNext()) {
                        System.out.print(itrRegNumber.next());
                        if (itrRegNumber.hasNext())
                            System.out.print(",");
                    }
                    System.out.println();
                    break;


                case Constant.slotNumberForRegistrationNumber:


                    Integer slotNumber = parkingFloorService.getSlotNumberForRegNumber(values[0]);
                    if(slotNumber==null) {
                        System.out.println("Not Found");
                    } else {
                        System.out.println(slotNumber);
                    }
                    break;


                case Constant.slotNumbersOfCarsWithColor:


                    List<Integer> listOfSlots = parkingFloorService.getListOfSlotsWithCarColor(values[0]);
                    if(listOfSlots==null || listOfSlots.isEmpty()) {
                        System.out.println("Not Found");
                        break;
                    }

                    Iterator itr = listOfSlots.iterator();
                    while (itr.hasNext()) {
                        System.out.print(itr.next());
                        if (itr.hasNext())
                            System.out.print(",");
                    }
                    System.out.println();
                    break;


                default:
                    System.out.println("Invalid input");

            }
        }
    }
}
