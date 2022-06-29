package org.oobootcamp.parkinglot;

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
}
