package com.oocl.parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager{

    List<ParkingBoy> parkingBoys;

    public ParkingLotManager() {
        this.parkingBoys = new ArrayList<>();
    }

    public ParkingTicket park(Car car){
        return null;
    }

    public int addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
        return parkingBoys.size();
    }

    public ParkingTicket callBoyParkCar(Car car) {
        ParkingBoy parkingBoy = parkingBoys.get(0);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        return parkingTicket;
    }

    public Car callBoyFetchCar(ParkingTicket parkingTicket) {
        ParkingBoy parkingBoy = parkingBoys.get(0);
        Car car = parkingBoy.fetch(parkingTicket);
        return car;
    }
}
