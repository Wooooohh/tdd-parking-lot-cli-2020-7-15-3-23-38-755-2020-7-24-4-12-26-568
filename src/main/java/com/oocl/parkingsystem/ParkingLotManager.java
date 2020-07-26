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
}
