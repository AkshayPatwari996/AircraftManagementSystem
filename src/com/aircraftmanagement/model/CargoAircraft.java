package com.aircraftmanagement.model;

public class CargoAircraft extends Aircraft {

    private double cargoCapacity;
    private String cargoType;

    public CargoAircraft(String aircraftId,
                         String model,
                         String manufacturer,
                         int capacity,
                         double cargoCapacity,
                         String cargoType) {

        super(aircraftId, model, manufacturer, capacity);

        this.cargoCapacity = cargoCapacity;
        this.cargoType = cargoType;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public String getCargoType() {
        return cargoType;
    }

    @Override
    public String getAircraftType() {
        return "Cargo Aircraft";
    }

    @Override
    public void displayDetails() {

        System.out.println("Aircraft ID: " + getAircraftId());
        System.out.println("Aircraft Type: " + getAircraftType());
        System.out.println("Model: " + getModel());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Cargo Capacity: " + cargoCapacity);
        System.out.println("Cargo Type: " + cargoType);
        System.out.println("Status: " + getStatus());
    }
}