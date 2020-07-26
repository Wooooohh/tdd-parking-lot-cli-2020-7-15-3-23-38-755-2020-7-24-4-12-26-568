# CLI Version

Please read the story and do your implementation.

## Story 1

As a customer, I would like to give my car to a parking boy so that he can help me park a car to the parking lot.

AC1: The parking boy can park a car into the parking lot and returns a parking ticket. The customer can give the parking ticket back to the parking boy to fetch the car.

AC2: The parking boy can park multiple cars into on parking lot. And can fetch right car using correspond ticket.

AC3: If the customer gives a wrong ticket (the parking boy does not provide the ticket) or does not give a ticket. Then no car should be fetched.

AC4: If the customer gives a ticket that has already been used. Then no car should be fetched.

AC5: The parking lot has a capacity (the default capacity of a parking lot is 10). If there is no position, then the user cannot park the car into it. Thus (s)he will not get any ticket.

> There are some cases which are not a requirement but may happen technically 
>
> * Passing a parked car to a parking boy.
> * Passing a `null` car to a parking boy.

# test case
1.should_return_parking_ticket_when_park_given_parking_boy_and_car
given : parking boy, car
when : park
then : ticket( is not null, just a ticket )

2.should_return_car_when_fetch_given_parking_ticket_and_parking_boy
given : parking ticket, parking boy ( one car in lot )
when : fetch
then : return car( is not null, just a car )

3.should_return_right_car_when_fetch_given_parking_ticket_and_parking_boy_and_two_cars_in_parking_lot
given : parking ticket, parking boy ( two cars in parking lot )
when : fetch
then : return car with right carid

4.should_return_multiple_parking_ticket_when_park_given_multiple_car_and_parking_boy
given : two car and parking boy
when : park
then :  return two parking ticket with right carId

5.should_return_null_when_fetch_given_wrong_parking_ticket_and_parking_boy
given : parking boy , wrong parking ticket
when : fetch
then : return null ( no car be fetched )

6.should_return_null_when_fetch_given_null_parking_ticket_and_parking_boy
given:  null parking ticket, parking boy
when : fetch 
then : return null ( no car be fetched )

7.should_return_null_when_fetch_given_used_parking_ticket_and_parking_boy
given:  used parking ticket, parking boy
when : fetch 
then : return null ( no car be fetched )

8.should_return_null_when_park_given_car_and_parking_boy_and_10_cars_in_parking_lot
given: parking ticket, parking boy (10 cars in parking lot)
when : park
then : return null ( cannot park the car into it )

## Story 2

As a customer, I would like to get some response message from the parking boy when I cannot fetch the car. So that I can know what happens.

AC1: When the customer gives a wrong ticket (the parking boy does not provide the ticket / the ticket has been used). Then no car should be fetched. If I query the error message, I can get an "Unrecognized parking ticket.".

AC2: When the customer does not provide a ticket when fetching a  car. The error message should be "Please provide your parking ticket."

AC3: When the parking boy attempt to park a car into a parking lot without a position. The error message should be "Not enough position."

# test case
9. should_return_error_message_unrecognized_parking_ticket_when_query_error_message_given_wrong_ticket_and_parking_boy
given : parking boy , wrong parking ticket
when : query error message
then : return error message "unrecognized parking."

10. should_return_error_message_please_provide_your_parking_ticket_when_query_error_message_given_null_ticket_and_parking_boy
given : parking boy , null parking ticket
when : query error message
then : return error message "Please provide your parking ticket."

11. should_return_error_message_not_enough_position_when_query_error_message_given_car_and_parking_boy_and_10_cars_in_parking_lot
given : parking ticket, parking boy (10 cars in parking lot)
when : query error message
then : return error message "Not enough position."

## Story 3

As a parking lots service manager, I would like to have a parking boy parking cars to multiple parking lots. So that I can provide more parking positions.

AC1. The parking boy is not that clever, and he will always park cars sequentially (suppose that there are two parking lots managed by the parking boy. The parking boy will park cars to the second parking lot when the first parking lot is full).

AC2: All the requirement in *Story 1* and *Story 2* **MUST** be satisfied.

# test case
12. should_return_ticket_with_lot_information_when_park_given_parking_boy_and_car_and_two_parking_lot_and_lot1_is_full
given : parking boy, car, two parking lot(lot1 is full)
when : park
then : return ticket with right lot information

13. should_return_ticket_with_lot_information_when_park_given_parking_boy_and_car_and_two_parking_lot_and_lot1_is_not_full
given : parking boy, car, two parking lot(lot1 is not full)
when : park
then : return ticket with right lot information

14.should_return_sequentially_ticket_with_lot_information_and_position_information_when_park_given_parking_boy_and_car_and_two_parking_lot_and_lot1_is_not_full
given : parking boy, two car, two parking lot(lot1 is not full)
when : park
then : return tickets with right position information

15.should_return_sequentially_ticket_with_lot_information_and_position_information_when_park_given_parking_boy_and_car_and_two_parking_lot_and_lot1_is_full
given : parking boy, two car, two parking lot(lot1 is full)
when : park
then : return tickets with right position information and right lot information


## Story 4

As a parking lots service manager. I would like to have another kind of parking boy to help me parking cars to multiple parking lots. So that the parking positions can be better used.

The new kind of parking boy is called **SMART PARKING BOY**.

AC1. The smart parking boy will always park cars to the parking lot which contains more empty positions.

AC2: All the requirement in *Story 1* and *Story 2* **MUST** be satisfied.

# test case
16.should_return_ticket_with_right_lot_information_when_park_given_smart_parking_boy_and_car_and_two_parking_lot_and_one_car_in_lot1
given : smart parking boy, car, two parking lot(one car in lot1, same capacity)
when : park
then : return tickets with right lot information

17.should_return_ticket_with_right_lot_information_when_park_given_smart_parking_boy_and_car_and_two_parking_lot_and_two_car_in_different_lot
given : smart parking boy, car, two parking lot(one car in lot1, one car in lot2)
when : park
then : return tickets with right lot information

## Story 5

As a parking lots service manager, I would like to have another kind of parking boy to help me parking cars to multiple parking lots so that the parking positions can be better used.

The new kind of parking boy is called **SUPER SMART PARKING BOY**.

AC1. The super smart parking boy will always park cars to the parking lot which has a larger available position rate (*positions available* / *total capacity*).

AC2: All the requirement in *Story 1* and *Story 2* **MUST** be satisfied.

# test case
rate = (positions available / capacity)
18.should_return_ticket_with_lot2_when_park_given_super_smart_parking_boy_and_car_and_two_parking_lot_and_lot2_rate_is_large
given : smart parking boy, car, two parking lot(lot2's rate is large)
when : park
then : return tickets with lot2

19. should_return_ticket_with_lot1_when_park_given_super_smart_parking_boy_and_car_and_two_parking_lot_and_lot1_rate_equals_lot2_rate
given : smart parking boy, car, two parking lot(lot1's rate and lot2's rate is equals)
when : park
then : return tickets with lot1

## Story 6

As a parking lot service manager, I would like to manage several parking boys (including all three kinds of parking boys). And at the same time, I can act as a standard parking boy too. So that our work can be most efficient.

Each parking lot service will have only one manager.

AC1. The parking lot service manager can add parking boys to management list. And the parking lot manager can specify a parking boy on the list to park or fetch the car (only from the parking lots managed by that parking boy).

AC2. The parking lot service manager can also manage parking lots. And (s)he can park or fetch the car just as a standard parking boy (*Story 3*). Note that (s)he can only store and fetch the car from his/her own parking lots.

AC3. If the manager tells the parking boy to park or fetch the car, then the manager should be able to display the error message to the customer if the parking boy failed to do the operation.

# test case
20.should_return_parking_boy_id_when_add_parking_boy_given_manager_and_parking_boy
given: parking boy, manager
when: add parking boy
then: parking boy id

21.should_return_ticket_when_call_boy_park_car_given_manager_with_one_parking_boy_in_parking_boy_list_and_car
given: parking boy, manager(one parking boy in parkingboylist), car 
when: park
then: return titcket(not null, just a titcket)

22.should_return_ticket_with_boy_id_is_2_when_call_boy_park_car_given_manager_with_two_parking_boy_in_parking_boy_list_and_boy1_is_full_and_car
given: manager(two parking boy in parkingboylist) , car, two parking boy(boy1 is full)
when: call boy park car
then: return ticket with boyid is 2

23.should_return_the_car_when_call_boy_fetch_car_given_manager_with_one_parking_boy_in_parking_boy_list_and_ticket_and_car
given: manager(one parking boy in parkingboylist) , car, titcket
when: call boy fetch car
then: car(right car in given)

24.should_return_the_car_when_call_boy_fetch_car_given_manager_with_multiple_parking_boy_in_parking_boy_list_and_ticket_and_car
given: manager(two parking boy in parkingboylist) , car, titcket
when: call boy fetch car
then: car(car in given)

25.should_return_the_car2_when_call_boy_fetch_car_given_manager_with_two_parking_boy_in_parking_boy_list_and_car2_in_boy2_and_ticket
given: manager(two parking boy in parkingboylist) , car( in boy2's lot ), titcket
when: call boy fetch car
then: car(right car in given)
