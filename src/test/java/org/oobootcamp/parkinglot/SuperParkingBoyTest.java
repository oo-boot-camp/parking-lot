package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
