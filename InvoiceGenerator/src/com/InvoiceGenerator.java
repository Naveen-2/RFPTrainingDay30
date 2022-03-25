package com;

public class InvoiceGenerator {


    private static final double MINIMUM_COST_PER_KILOMETER = 10.00;
    private static final int COST_PER_TIME = 1;
    private static final int MINIMUM_FARE = 5;

    public static void main(String[] args){
        System.out.println(calculateFare(5,10));
    }
    public static double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if(totalFare < MINIMUM_FARE)
        {
            return MINIMUM_FARE;
        }
        return totalFare;

    }
}
