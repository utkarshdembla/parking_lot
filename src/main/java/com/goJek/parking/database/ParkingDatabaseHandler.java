package com.goJek.parking.database;

import com.goJek.parking.model.ParkingFloor;

import java.util.ArrayList;
import java.util.List;

public interface ParkingDatabaseHandler {

    void saveParkingFloor(ParkingFloor parkingFloor);

    ParkingFloor getParkingFloor();

}
