package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.FlightNotFoundException;
import com.aircraftmanagement.exception.InvalidFlightException;
import com.aircraftmanagement.model.Aircraft;
import com.aircraftmanagement.model.Flight;
import com.aircraftmanagement.model.Pilot;

public class FlightManager {

    private Flight[] flights;
    private int count;

    public FlightManager(int size) {
        flights = new Flight[size];
        count = 0;
    }

    public void scheduleFlight(String flightId,
                               String source,
                               String destination,
                               Aircraft aircraft,
                               Pilot pilot)
            throws InvalidFlightException {

        if (count == flights.length) {
            throw new IllegalStateException(
                    "Flight storage is full."
            );
        }

        if (findFlightById(flightId) != null) {
            throw new InvalidFlightException(
                    "Flight ID already exists: " + flightId
            );
        }

        if (source.equalsIgnoreCase(destination)) {
            throw new InvalidFlightException(
                    "Source and destination cannot be the same."
            );
        }

        if (aircraft == null) {
            throw new InvalidFlightException(
                    "Aircraft is required."
            );
        }

        if (pilot == null) {
            throw new InvalidFlightException(
                    "Pilot is required."
            );
        }

        if (!aircraft.getStatus().equalsIgnoreCase("AVAILABLE")) {
            throw new InvalidFlightException(
                    "Aircraft is not available."
            );
        }

        if (!pilot.getAvailability()
                .equalsIgnoreCase("AVAILABLE")) {

            throw new InvalidFlightException(
                    "Pilot is not available."
            );
        }

        Flight flight = new Flight(
                flightId,
                source,
                destination,
                aircraft,
                pilot
        );

        flights[count] = flight;
        count++;

        aircraft.setStatus("UNAVAILABLE");
        pilot.setAvailability("UNAVAILABLE");

        System.out.println("Flight scheduled successfully.");
    }

    public Flight searchFlight(String flightId)
            throws FlightNotFoundException {

        Flight flight = findFlightById(flightId);

        if (flight == null) {
            throw new FlightNotFoundException(
                    "Flight not found: " + flightId
            );
        }

        return flight;
    }

    private Flight findFlightById(String flightId) {

        for (int i = 0; i < count; i++) {

            if (flights[i].getFlightId()
                    .equalsIgnoreCase(flightId)) {

                return flights[i];
            }
        }

        return null;
    }

    public void displayAllFlights() {

        if (count == 0) {
            System.out.println("No flights available.");
            return;
        }

        for (int i = 0; i < count; i++) {

            flights[i].displayDetails();

            System.out.println("-------------------------");
        }
    }

    public void cancelFlight(String flightId)
            throws FlightNotFoundException {

        Flight flight = searchFlight(flightId);

        if (flight.getFlightStatus()
                .equalsIgnoreCase("CANCELLED")) {

            System.out.println("Flight is already cancelled.");
            return;
        }

        flight.setFlightStatus("CANCELLED");

        flight.getAircraft().setStatus("AVAILABLE");

        flight.getPilot().setAvailability("AVAILABLE");

        System.out.println("Flight cancelled successfully.");
        System.out.println("Aircraft is now available.");
        System.out.println("Pilot is now available.");
    }
}