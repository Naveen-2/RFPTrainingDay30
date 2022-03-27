package com;

public class InvoiceGenerator {


    private static final double MINIMUM_COST_PER_KILOMETER = 10.00;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if(totalFare < MINIMUM_FARE)
        {
            return MINIMUM_FARE;
        }
        return totalFare;

    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride: rides){
            totalFare += calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }
}
