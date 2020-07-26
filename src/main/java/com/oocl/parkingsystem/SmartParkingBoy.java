package com.oocl.parkingsystem;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public ParkingTicket park(Car car) {
        int maxEmptyPositionLotIndex = 0;
        int currLotEmptyPositionNum = 0;
        if (carsMap.size() < totalCapacity) {
            for(int i = 0; i < parkingLots.size(); i++){
                ParkingLot parkingLot = parkingLots.get(i);
                if (!parkingLots.get(i).isFull()) {
                    int emptyPositionNum = parkingLot.getCapacity() - parkingLot.getCarsNum();
                    if(parkingLot.getCapacity() - parkingLot.getCarsNum() > currLotEmptyPositionNum){
                        maxEmptyPositionLotIndex = i;
                        currLotEmptyPositionNum = emptyPositionNum;
                    }
                }
            }
            String carId = car.getCarId();
            ParkingLot maxEmptyPositionLot = parkingLots.get(maxEmptyPositionLotIndex);
            maxEmptyPositionLot.putCar(car);
            ParkingTicket parkingTicket = new ParkingTicket(carId, maxEmptyPositionLot.getLotId(), maxEmptyPositionLot.getPosition());
            String ticketId = parkingTicket.getTicketId();
            carsMap.put(ticketId, carId);
            return parkingTicket;
        }
        return null;
    }

}
