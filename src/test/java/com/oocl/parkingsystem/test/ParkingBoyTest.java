package com.oocl.parkingsystem.test;

import com.oocl.parkingsystem.Car;
import com.oocl.parkingsystem.ParkingBoy;
import com.oocl.parkingsystem.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParkingBoyTest {

    @Test
    public void should_return_parking_ticket_when_park_given_parking_boy_and_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();

        //when
        ParkingTicket result = parkingBoy.park(car);

        //then
        assertNotEquals(null, result);
    }

    @Test
    public void should_return_car_when_when_fetch_given_parking_ticket_and_parking_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car result = parkingBoy.fetch(parkingTicket);

        //then
        assertNotEquals(null, result);
    }

}
