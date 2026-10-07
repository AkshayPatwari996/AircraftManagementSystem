package com.aircraftmanagement.model;

public class PassengerAircraft extends Aircraft {

    private int numberOfPassengers;
    private boolean businessClassAvailable;

    public PassengerAircraft(String aircraftId,
                             String model,
                             String manufacturer,
                             int capacity,
                             int numberOfPassengers,
                             boolean businessClassAvailable) {

        super(aircraftId, model, manufacturer, capacity);

        this.numberOfPassengers = numberOfPassengers;
        this.businessClassAvailable = businessClassAvailable;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public boolean isBusinessClassAvailable() {
        return businessClassAvailable;
    }

    @Override
    public String getAircraftType() {
        return "Passenger Aircraft";
    }

    @Override
    public void displayDetails() {

        System.out.println("Aircraft ID: " + getAircraftId());
        System.out.println("Aircraft Type: " + getAircraftType());
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Number of Passengers: " + numberOfPassengers);
        System.out.println("Business Class Available: "
                + businessClassAvailable);
        System.out.println("Status: " + getStatus());
    }
}