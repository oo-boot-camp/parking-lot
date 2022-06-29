package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkinglot.exception.SuperParkingBoyCannotParkException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertThrows(SuperParkingBoyCannotParkException.class, () -> superParkingBoy.park(new Car()));
    }
}
