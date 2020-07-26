package com.oocl.parkingsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartParkingBoy {

    Map<String, String> carsMap;

    int totalCapacity;

    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        carsMap = new HashMap<>();
        for(ParkingLot parkingLot : parkingLots){
            totalCapacity += parkingLot.getCapacity();
        }
    }

    public ParkingTicket park(Car car) {
        if (carsMap.size() < totalCapacity) {
            for(ParkingLot parkingLot : parkingLots){
                if (!parkingLot.isFull()) {
                    String carId = car.getCarId();
                    parkingLot.putCar(car);
                    ParkingTicket parkingTicket = new ParkingTicket(carId, parkingLot.getLotId(), parkingLot.getPosition());
                    String ticketId = parkingTicket.getTicketId();
                    carsMap.put(ticketId, carId);
                    return parkingTicket;
                }
            }
        }
        return null;
    }
}
