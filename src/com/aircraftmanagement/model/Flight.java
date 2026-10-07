package com.aircraftmanagement.model;

public class Flight {

    private String flightId;
    private String source;
    private String destination;
    private Aircraft aircraft;
    private Pilot pilot;
    private String flightStatus;

    public Flight(String flightId,
                  String source,
                  String destination,
                  Aircraft aircraft,
                  Pilot pilot) {

        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.aircraft = aircraft;
        this.pilot = pilot;
        this.flightStatus = "SCHEDULED";
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public void displayDetails() {

        System.out.println("Flight ID: " + flightId);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Aircraft ID: "
                + aircraft.getAircraftId());
        System.out.println("Aircraft Type: "
                + aircraft.getAircraftType());
        System.out.println("Pilot ID: "
                + pilot.getPilotId());
        System.out.println("Pilot Name: "
                + pilot.getPilotName());
        System.out.println("Flight Status: "
                + flightStatus);
    }
}