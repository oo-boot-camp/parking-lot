package org.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingBoy {
    protected final List<ParkingLot> parkingLots = new ArrayList<>();

    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public int getManagedParkingLots() {
        return parkingLots.size();
    }

    public abstract void park(Car car);
}
