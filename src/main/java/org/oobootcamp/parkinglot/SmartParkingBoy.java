package org.oobootcamp.parkinglot;

import org.oobootcamp.parkinglot.exception.SmartParkingBoyNotManageParkingLot;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    public void park(Car car) {
        if (parkingLots.isEmpty()) {
            throw new SmartParkingBoyNotManageParkingLot();
        }
        ParkingLot parkingLot = getParkingLotWithMostAvailableLots();
        parkingLot.park(car);
    }

    private ParkingLot getParkingLotWithMostAvailableLots() {
        ParkingLot parkingLot = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot currentParkingLot = parkingLots.get(i);
            if (currentParkingLot.getAvailableLots() > parkingLot.getAvailableLots()) {
                parkingLot = currentParkingLot;
            }
        }
        return parkingLot;
    }
}
