package com.aircraftmanagement.model;

public abstract class Aircraft {

    private String aircraftId;
    private String model;
    private String manufacturer;
    private int capacity;
    private String status;

    public Aircraft(String aircraftId,
                    String model,
                    String manufacturer,
                    int capacity) {

        this.aircraftId = aircraftId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.status = "AVAILABLE";
    }

    public String getAircraftId() {
        return aircraftId;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void start() {
        System.out.println("Aircraft " + aircraftId + " started.");
    }

    public void stop() {
        System.out.println("Aircraft " + aircraftId + " stopped.");
    }

    public void validateCapacity() {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Aircraft capacity must be greater than zero."
            );
        }
    }

    public abstract String getAircraftType();

    public abstract void displayDetails();
}