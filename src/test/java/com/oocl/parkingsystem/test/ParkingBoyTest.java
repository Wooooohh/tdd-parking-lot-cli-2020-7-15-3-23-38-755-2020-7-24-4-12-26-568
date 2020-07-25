package com.oocl.parkingsystem.test;

import com.oocl.parkingsystem.Car;
import com.oocl.parkingsystem.ParkingBoy;
import com.oocl.parkingsystem.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParkingBoyTest {

  @Test
  public void should_return_parking_ticket_when_park_given_parking_boy_and_car() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    Car car = new Car("H001");

    // when
    ParkingTicket result = parkingBoy.park(car);

    // then
    assertNotEquals(null, result);
  }

  @Test
  public void should_return_car_when_fetch_given_parking_ticket_and_parking_boy() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    ParkingTicket parkingTicket = new ParkingTicket("H001park");

    // when
    Car result = parkingBoy.fetch(parkingTicket);

    // then
    assertNotEquals(null, result);
  }

  @Test
  public void
      should_return_right_car_when_fetch_given_parking_ticket_and_parking_boy_and_two_cars_in_parking_lot() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    Car car1 = new Car("H001");
    Car car2 = new Car("H002");
    ParkingTicket ticket1 = parkingBoy.park(car1);
    ParkingTicket ticket2 = parkingBoy.park(car2);

    // then
    Car result = parkingBoy.fetch(ticket2);

    // then
    assertEquals(car2.getCarId(), result.getCarId());
  }

  @Test
  public void should_return_multiple_parking_ticket_when_park_given_multiple_car_and_parking_boy() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    Car car1 = new Car("H001");
    Car car2 = new Car("H002");
    Car[] cars = {car1, car2};
    ParkingTicket ticket1 = new ParkingTicket(car1.getCarId());
    ParkingTicket ticket2 = new ParkingTicket(car2.getCarId());

    ParkingTicket[] tickets = {ticket1, ticket2};
    // when
    ParkingTicket[] result = parkingBoy.park(cars);

    // then
    for (int i = 0; i < cars.length; i++) {
      assertEquals(tickets[i].getTicketId(), result[i].getTicketId());
    }
  }

  @Test
  public void should_return_null_when_fetch_given_wrong_parking_ticket_and_parking_boy() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    ParkingTicket ticket = new ParkingTicket("wrong ticket");

    // when
    Car car = parkingBoy.fetch(ticket);

    // then
    assertEquals(null, car);
  }

  @Test
  public void should_return_null_when_fetch_given_null_parking_ticket_and_parking_boy() {
    // given
    ParkingBoy parkingBoy = new ParkingBoy();
    ParkingTicket ticket = null;

    // when
    Car car = parkingBoy.fetch(ticket);

    // then
    assertEquals(null, car);
  }
}
