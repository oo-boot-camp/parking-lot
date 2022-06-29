package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkinglot.exception.ParkingBoyNotManageParkingLotException;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {

    @Test
    void should_smart_parking_boy_can_manage_multiple_parking_lots() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingLot bigParkingLot = new ParkingLot(2);
        smartParkingBoy.manage(smallParkingLot);
        smartParkingBoy.manage(bigParkingLot);
        assertEquals(smartParkingBoy.getManagedParkingLots(), 2);
    }

    @Test
    void should_smart_parking_boy_cannot_park_when_not_manage_any_parking_lot() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        assertThrows(ParkingBoyNotManageParkingLotException.class, () -> smartParkingBoy.park(new Car()));
    }

    @Test
    void should_smart_parking_boy_can_park_car_in_parking_lots_which_with_more_lots_when_parking_car() {
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingLot bigParkingLot = new ParkingLot(2);
        smartParkingBoy.manage(smallParkingLot);
        smartParkingBoy.manage(bigParkingLot);
        smartParkingBoy.park(new Car());
        assertEquals(smallParkingLot.getAvailableLots(), 1);
        assertEquals(bigParkingLot.getAvailableLots(), 1);
    }
}
