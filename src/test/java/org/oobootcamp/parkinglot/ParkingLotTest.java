package org.oobootcamp.parkinglot;

import org.junit.jupiter.api.Test;
import org.oobootcamp.parkinglot.exception.ParkingLotFullException;
import org.oobootcamp.parkinglot.exception.TicketInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_a_valid_ticket_when_park_a_car_given_parking_lot_with_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        assertThat(ticket).isNotNull();
    }

    @Test
    void should_fail_when_park_car_given_parking_lot_full() {
        ParkingLot parkingLot = new ParkingLot(0);

        assertThrows(ParkingLotFullException.class, () -> parkingLot.park(new Car()));
    }

    @Test
    void should_pick_my_car_when_pick_given_valid_ticket_and_parking_lot_with_my_car_parked_in() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();

        Ticket ticket = parkingLot.park(myCar);

        Car pickedCar = parkingLot.pick(ticket);

        assertSame(myCar, pickedCar);
    }

    @Test
    void should_fail_when_pick_with_invalid_ticket_given_parking_lot_with_cars_parked_in() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(new Car());

        assertThrows(TicketInvalidException.class, () -> parkingLot.pick(new Ticket()));
    }

    @Test
    void should_fail_when_pick_twice_given_parking_lot_with_cars_parked_in() {
        ParkingLot parkingLot = new ParkingLot(2);
        Ticket ticket = parkingLot.park(new Car());
        parkingLot.pick(ticket);

        assertThrows(TicketInvalidException.class, () -> parkingLot.pick(ticket));
    }

    @Test
    void should_get_available_parking_lots_when_parked_car() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertEquals(parkingLot.getAvailableLots(), 1);
    }

}
