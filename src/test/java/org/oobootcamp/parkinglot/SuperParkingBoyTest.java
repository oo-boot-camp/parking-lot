package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkinglot.exception.ParkingBoyNotManageParkingLotException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperParkingBoyTest {

    @Test
    void should_super_parking_boy_can_manage_multiple_parking_lots() {
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingLot bigParkingLot = new ParkingLot(2);
        superParkingBoy.manage(smallParkingLot);
        superParkingBoy.manage(bigParkingLot);
        assertEquals(superParkingBoy.getManagedParkingLots(), 2);
    }

    @Test
    void should_super_parking_boy_cannot_park_when_not_manage_any_parking_lot() {
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        assertThrows(ParkingBoyNotManageParkingLotException.class, () -> superParkingBoy.park(new Car()));
    }

    @Test
    void should_super_parking_boy_can_park_car_in_parking_lots_which_with_higher_vacancy_rate_when_parking_car() {
        // Given
        ParkingLot parkingLotWithHigherVacancyRate = new ParkingLot(2);
        parkingLotWithHigherVacancyRate.park(new Car());
        ParkingLot parkingLotWithLowerVacancyRate = new ParkingLot(3);
        parkingLotWithLowerVacancyRate.park(new Car());
        parkingLotWithLowerVacancyRate.park(new Car());
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        superParkingBoy.manage(parkingLotWithHigherVacancyRate);
        superParkingBoy.manage(parkingLotWithLowerVacancyRate);

        // When
        superParkingBoy.park(new Car());

        // Then
        assertTrue(parkingLotWithHigherVacancyRate.isFull());
    }
}
