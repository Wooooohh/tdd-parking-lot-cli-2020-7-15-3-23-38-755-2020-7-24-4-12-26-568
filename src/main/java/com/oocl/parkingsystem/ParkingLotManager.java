package com.oocl.parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

  List<ParkingBoy> parkingBoys;

  public ParkingLotManager() {
    this.parkingBoys = new ArrayList<>();
  }

  public ParkingTicket park(Car car) {
    return null;
  }

  public int addParkingBoy(ParkingBoy parkingBoy) {
    parkingBoys.add(parkingBoy);
    parkingBoy.setBoyId(parkingBoys.size());
    return parkingBoys.size();
  }

  public ParkingTicket callBoyParkCar(Car car) {
    for (ParkingBoy parkingBoy : parkingBoys) {
      if (!parkingBoy.isLotsFull()) {
        ParkingTicket parkingTicket = parkingBoy.park(car);
        return parkingTicket;
      }
    }
    return null;
  }

  public Car callBoyFetchCar(ParkingTicket parkingTicket) {
    ParkingBoy parkingBoy = parkingBoys.get(0);
    Car car = parkingBoy.fetch(parkingTicket);
    return car;
  }
}
