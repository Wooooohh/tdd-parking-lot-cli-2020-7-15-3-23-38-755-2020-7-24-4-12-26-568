package com.oocl.parkingsystem;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{


    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car) {
        int maxRateLotIndex = 0;
        int currLotRate = 0;
        if (carsMap.size() < totalCapacity) {
            for(int i = 0; i < parkingLots.size(); i++){
                ParkingLot parkingLot = parkingLots.get(i);
                if (!parkingLots.get(i).isFull()) {
                    int rate = (parkingLot.getCapacity() - parkingLot.getCarsNum()) / parkingLot.getCapacity();
                    if( rate > currLotRate){
                        maxRateLotIndex = i;
                        currLotRate = rate;
                    }
                }
            }
            String carId = car.getCarId();
            ParkingLot maxEmptyPositionLot = parkingLots.get(maxRateLotIndex);
            maxEmptyPositionLot.putCar(car);
            ParkingTicket parkingTicket = new ParkingTicket(carId, maxEmptyPositionLot.getLotId(), maxEmptyPositionLot.getPosition());
            String ticketId = parkingTicket.getTicketId();
            carsMap.put(ticketId, carId);
            return parkingTicket;
        }
        return null;
    }

}
