package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    @Test
    public void givenDistanceTime_ShouldReturnTotalFare()
    {
        double distance = 2.0;
        int time = 5;
        double fare = InvoiceGenerator.calculateFare(distance, time);
        assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = InvoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare(){
        Ride[] rides = {new Ride(2, 5),
                        new Ride(.1,1)};
        double fare = InvoiceGenerator.calculateFare(rides);
        assertEquals(30,fare,0.0);
    }
}