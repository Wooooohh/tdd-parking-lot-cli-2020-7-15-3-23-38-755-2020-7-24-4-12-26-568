package com.oocl.parkingsystem;


public class ParkingBoy {

    public ParkingTicket park(Car car){
        return new ParkingTicket();
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return new Car("H001");
    }
}
