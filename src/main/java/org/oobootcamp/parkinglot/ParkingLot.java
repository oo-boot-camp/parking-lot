package org.oobootcamp.parkinglot;


import org.oobootcamp.parkinglot.exception.ParkingLotFullException;
import org.oobootcamp.parkinglot.exception.TicketInvalidException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int space;
    private final Map<Ticket, Car> parkedCars = new HashMap<>();

    public ParkingLot(int space) {
        this.space = space;
    }

    public Ticket park(Car car) {
        if (isFull()) {
            throw new ParkingLotFullException();
        }
        Ticket ticket = new Ticket();
        parkedCars.put(ticket, car);
        return ticket;
    }

    public boolean isFull() {
        return parkedCars.size() >= space;
    }

    public Car pick(Ticket ticket) {
        if (parkedCars.containsKey(ticket)) {
            return parkedCars.remove(ticket);
        }
        throw new TicketInvalidException();
    }

    public int getAvailableLots() {
        return space - parkedCars.size();
    }

    public double getVacancyRate() {
        return getAvailableLots() * 1.0 / space;
    }
}