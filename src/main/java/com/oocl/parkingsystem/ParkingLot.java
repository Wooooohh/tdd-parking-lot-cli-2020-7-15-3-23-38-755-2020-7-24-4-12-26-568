package com.oocl.parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int lotId;

    private int capacity;

    private List<Car> cars;

    public ParkingLot(int lotId, int capacity) {
        this.lotId = lotId;
        this.capacity = capacity;
        cars = new ArrayList<>();
    }

    public void putCar(Car car){
        this.cars.add(car);
    }

    public Car getCar(int index){
        return cars.get(index-1);
    }

    public int getCarsNum(){
        return cars.size();
    }

    public boolean isFull(){
        return cars.size() >= capacity;
    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPosition() {
        return cars.size();
    }
}
