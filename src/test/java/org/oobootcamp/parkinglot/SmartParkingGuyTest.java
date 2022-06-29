package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkinglot.exception.SmartParkingGuyNotManageParkingLot;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingGuyTest {

    @Test
    void should_smart_parking_guy_can_manage_multiple_parking_lots() {
        SmartParkingGuy smartParkingGuy = new SmartParkingGuy();
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingLot bigParkingLot = new ParkingLot(2);
        smartParkingGuy.manage(smallParkingLot);
        smartParkingGuy.manage(bigParkingLot);
        assertEquals(smartParkingGuy.getManagedParkingLots(), 2);
    }

    @Test
    void should_smart_parking_guy_cannot_park_when_not_manage_any_parking_lot() {
        SmartParkingGuy smartParkingGuy = new SmartParkingGuy();
        assertThrows(SmartParkingGuyNotManageParkingLot.class, () -> smartParkingGuy.park(new Car()));
    }

    @Test
    void should_smart_parking_guy_can_park_car_in_parking_lots_which_with_more_lots_when_parking_car() {
        SmartParkingGuy smartParkingGuy = new SmartParkingGuy();
        ParkingLot smallParkingLot = new ParkingLot(1);
        ParkingLot bigParkingLot = new ParkingLot(2);
        smartParkingGuy.manage(smallParkingLot);
        smartParkingGuy.manage(bigParkingLot);
        smartParkingGuy.park(new Car());
        assertEquals(smallParkingLot.getAvailableLots(), 1);
        assertEquals(bigParkingLot.getAvailableLots(), 1);
    }
}
