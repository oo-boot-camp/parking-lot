package org.oobootcamp.parkinglot;

import org.oobootcamp.parkinglot.exception.SuperParkingBoyCannotParkException;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoy {
    private final List<ParkingLot> parkingLots = new ArrayList<>();
    public void manage(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public int getManagedParkingLots() {
        return parkingLots.size();
    }

    public void park(Car car) {
        if (parkingLots.isEmpty()) {
            throw new SuperParkingBoyCannotParkException();
        }
        ParkingLot parkingLot = getParkingLotWithHigherVacancyRate();
        parkingLot.park(car);
    }

    private ParkingLot getParkingLotWithHigherVacancyRate() {
        ParkingLot parkingLotWithHigherVacancyRate = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            ParkingLot currentParkingLot = parkingLots.get(i);
            if (currentParkingLot.getVacancyRate() > parkingLotWithHigherVacancyRate.getVacancyRate()) {
                parkingLotWithHigherVacancyRate = currentParkingLot;
            }
        }
        return parkingLotWithHigherVacancyRate;
    }
}
