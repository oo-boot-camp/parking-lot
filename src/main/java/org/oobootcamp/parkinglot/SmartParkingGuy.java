package org.oobootcamp.parkinglot;

import org.oobootcamp.parkinglot.exception.SmartParkingGuyNotManageParkingLot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingGuy {

    private final List<ParkingLot> parkingLots = new ArrayList<>();
    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public int getManagedParkingLots() {
        return parkingLots.size();
    }


    public void park(Car car) {
        if (parkingLots.isEmpty()) {
            throw new SmartParkingGuyNotManageParkingLot();
        }
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot currentParkingLot = parkingLots.get(i);
            if (currentParkingLot.getAvailableLots() > parkingLot.getAvailableLots()) {
                parkingLot = currentParkingLot;
            }
        }
        parkingLot.park(car);
    }
}
