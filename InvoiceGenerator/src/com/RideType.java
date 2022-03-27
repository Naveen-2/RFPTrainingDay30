package com;

public enum RideType {

    NORMAL_RIDE(10.0,1,5.0), PREMIUM_RIDE(15.0,2,20);

    public final double costPerKm;
    public final int costPerTime;
    public final double minFare;

    RideType(double costPerKm, int costPerTime, double minFare){
        this.costPerKm = costPerKm;
        this.costPerTime = costPerTime;
        this.minFare = minFare;
    }

    public double calculateFare(Ride ride){
        return Math.max((ride.getDistance() * costPerKm) + (ride.getTime() * costPerTime), minFare);
    }

}
