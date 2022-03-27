package com;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    @Test
    public void givenDistanceTime_ShouldReturnTotalFare()
    {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary(){

        Ride[] rides = {
                new Ride(RideType.NORMAL_RIDE, 2, 5),
                new Ride(RideType.NORMAL_RIDE, .1,1)
        };

        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedSummary,summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        String userId = "nvn11";

        Ride[] rides = {
                new Ride(RideType.NORMAL_RIDE, 2.0, 5),
                new Ride(RideType.NORMAL_RIDE, 0.1, 1)
        };

        invoiceGenerator.addRide(userId, rides);
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenTwoCategoriesOfRides_ShouldReturnTheInvoiceSummary() {
        String userId = "nvn11";

        Ride[] rides = {
                new Ride(RideType.NORMAL_RIDE, 2.0, 5),
                new Ride(RideType.NORMAL_RIDE, 0.1, 1),
                new Ride(RideType.PREMIUM_RIDE, 0.1, 1)
        };

        invoiceGenerator.addRide(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, summary);
    }
}