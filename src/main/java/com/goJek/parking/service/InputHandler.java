package com.goJek.parking.service;
import com.goJek.parking.config.Constant;

public class InputHandler {

    ParkingFloorService parkingFloorService = new ParkingFloorServiceImplementation();

    public void inputCommandService(String command,String[] values) {
        if (command != null) {
            switch (command.toLowerCase()) {
                case Constant.createParkingLot:
                    parkingFloorService.createParkingFloor(Integer.valueOf(values[0]));
                    break;
                case Constant.leave:
                    parkingFloorService.remove(values[0]);
                    break;
                case Constant.park:
                    parkingFloorService.park(values[0],values[1]);
                    break;
                case Constant.status:
                    parkingFloorService.getStatus();
                    break;
                case Constant.registrationNumbersForCarsWithColor:
                    parkingFloorService.getListOfRegNumberWithColor(values[0]);
                    break;
                case Constant.slotNumberForRegistrationNumber:
                    parkingFloorService.getSlotNumberForRegNumber(values[0]);
                    break;
                case Constant.slotNumbersOfCarsWithColor:
                    parkingFloorService.getListOfSlotsWithCarColor(values[0]);
                    break;
                default:
                    System.out.println("Invalid input");

            }
        }
    }
}
