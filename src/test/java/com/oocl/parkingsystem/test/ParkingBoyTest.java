package com.oocl.parkingsystem.test;

import com.oocl.parkingsystem.Car;
import com.oocl.parkingsystem.ParkingBoy;
import com.oocl.parkingsystem.ParkingLot;
import com.oocl.parkingsystem.ParkingTicket;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ParkingBoyTest {

  @Test
  public void should_return_parking_ticket_when_park_given_parking_boy_and_car() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    Car car = new Car("H001");

    // when
    ParkingTicket result = parkingBoy.park(car);

    // then
    assertNotEquals(null, result);
  }

  @Test
  public void should_return_car_when_fetch_given_parking_ticket_and_parking_boy() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    ParkingTicket parkingTicket = parkingBoy.park(new Car("H001"));

    // when
    Car result = parkingBoy.fetch(parkingTicket);

    // then
    assertNotEquals(null, result);
  }

  @Test
  public void
      should_return_right_car_when_fetch_given_parking_ticket_and_parking_boy_and_two_cars_in_parking_lot() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
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
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    Car car1 = new Car("H001");
    Car car2 = new Car("H002");
    Car[] cars = {car1, car2};
    ParkingTicket ticket1 = new ParkingTicket(car1.getCarId(), 1);
    ParkingTicket ticket2 = new ParkingTicket(car2.getCarId(), 2);

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
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    ParkingTicket ticket = new ParkingTicket("wrong ticket", 0);

    // when
    Car car = parkingBoy.fetch(ticket);

    // then
    assertEquals(null, car);
  }

  @Test
  public void should_return_null_when_fetch_given_null_parking_ticket_and_parking_boy() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    ParkingTicket ticket = null;

    // when
    Car car = parkingBoy.fetch(ticket);

    // then
    assertEquals(null, car);
  }

  @Test
  public void should_return_null_when_fetch_given_used_parking_ticket_and_parking_boy() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    Car car = new Car("H001");
    ParkingTicket ticket = parkingBoy.park(car);
    parkingBoy.fetch(ticket);
    // when
    Car result = parkingBoy.fetch(ticket);

    // then
    assertEquals(null, result);
  }

  @Test
  public void should_return_null_when_park_given_car_and_parking_boy_and_10_cars_in_parking_lot() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    for (int i = 0; i < 10; i++) {
      parkingBoy.park(new Car("H00" + i));
    }
    // when
    ParkingTicket parkingTicket = parkingBoy.park(new Car("H0011"));

    // then
    assertEquals(null, parkingTicket);
  }

  @Test
  public void
      should_return_error_message_unrecognized_parking_ticket_when_query_error_message_given_wrong_ticket_and_parking_boy() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    parkingBoy.park(new Car("H001"));
    ParkingTicket parkingTicket = new ParkingTicket("wrong ticket", 0);
    parkingBoy.fetch(parkingTicket);

    // then
    String result = parkingBoy.queryErrorMessage(parkingTicket);

    // then
    assertEquals("Unrecognized parking ticket.", result);
  }

  @Test
  public void
      should_return_error_message_please_provide_your_parking_ticket_when_query_error_message_given_null_ticket_and_parking_boy() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    parkingBoy.park(new Car("H001"));
    ParkingTicket parkingTicket = null;
    parkingBoy.fetch(parkingTicket);

    // then
    String result = parkingBoy.queryErrorMessage(parkingTicket);

    // then
    assertEquals("Please provide your parking ticket.", result);
  }

  @Test
  public void
      should_return_error_message_not_enough_position_when_query_error_message_given_car_and_parking_boy_and_10_cars_in_parking_lot() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    parkingLots.add(parkingLot1);
    for (int i = 0; i < 10; i++) {
      parkingBoy.park(new Car("H00" + i));
    }
    Car car11 = new Car("H0011");
    parkingBoy.park(car11);
    // when
    String result = parkingBoy.queryErrorMessage(car11);

    // then
    assertEquals("Not enough position.", result);
  }

  @Test
  public void
      should_return_ticket_with_lot_information_when_park_given_parking_boy_and_car_and_two_parking_lot_and_lot1_is_not_full() {
    // given
    ParkingLot parkingLot1 = new ParkingLot(1, 10);
    ParkingLot parkingLot2 = new ParkingLot(2, 10);
    List<ParkingLot> parkingLots = new ArrayList<>();
    parkingLots.add(parkingLot1);
    parkingLots.add(parkingLot2);
    ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
    Car car = new Car("H001");

    // when
    ParkingTicket result = parkingBoy.park(car);

    // then
    assertEquals(1, result.getParkingLotId());
  }
}
