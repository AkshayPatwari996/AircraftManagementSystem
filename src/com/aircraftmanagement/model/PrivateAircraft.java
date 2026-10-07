package com.aircraftmanagement.model;

public class PrivateAircraft extends Aircraft {

    private String ownerName;
    private String luxuryLevel;

    public PrivateAircraft(String aircraftId,
                           String model,
                           String manufacturer,
                           int capacity,
                           String ownerName,
                           String luxuryLevel) {

        super(aircraftId, model, manufacturer, capacity);

        this.ownerName = ownerName;
        this.luxuryLevel = luxuryLevel;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getLuxuryLevel() {
        return luxuryLevel;
    }

    @Override
    public String getAircraftType() {
        return "Private Aircraft";
    }

    @Override
    public void displayDetails() {

        System.out.println("Aircraft ID: " + getAircraftId());
        System.out.println("Aircraft Type: " + getAircraftType());
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Luxury Level: " + luxuryLevel);
        System.out.println("Status: " + getStatus());
    }
}