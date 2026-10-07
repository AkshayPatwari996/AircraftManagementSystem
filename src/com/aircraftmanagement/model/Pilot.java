package com.aircraftmanagement.model;

public class Pilot {

    private String pilotId;
    private String pilotName;
    private String licenseNumber;
    private int experience;
    private String availability;

    public Pilot(String pilotId,
                 String pilotName,
                 String licenseNumber,
                 int experience) {

        this.pilotId = pilotId;
        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experience = experience;
        this.availability = "AVAILABLE";
    }

    public String getPilotId() {
        return pilotId;
    }

    public String getPilotName() {
        return pilotName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getExperience() {
        return experience;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void displayDetails() {

        System.out.println("Pilot ID: " + pilotId);
        System.out.println("Pilot Name: " + pilotName);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Experience: " + experience + " years");
        System.out.println("Availability: " + availability);
    }
}