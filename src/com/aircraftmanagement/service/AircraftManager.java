package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.AircraftAlreadyExistsException;
import com.aircraftmanagement.exception.AircraftNotFoundException;
import com.aircraftmanagement.model.Aircraft;

public class AircraftManager {

    private Aircraft[] aircrafts;
    private int count;

    public AircraftManager(int size) {
        aircrafts = new Aircraft[size];
        count = 0;
    }

    public void registerAircraft(Aircraft aircraft)
            throws AircraftAlreadyExistsException {

        if (count == aircrafts.length) {
            throw new IllegalStateException(
                    "Aircraft storage is full."
            );
        }

        if (searchAircraftById(aircraft.getAircraftId()) != null) {
            throw new AircraftAlreadyExistsException(
                    "Aircraft ID already exists: "
                            + aircraft.getAircraftId()
            );
        }

        aircraft.validateCapacity();

        aircrafts[count] = aircraft;
        count++;

        System.out.println("Aircraft registered successfully.");
    }

    public Aircraft searchAircraft(String aircraftId)
            throws AircraftNotFoundException {

        Aircraft aircraft = searchAircraftById(aircraftId);

        if (aircraft == null) {
            throw new AircraftNotFoundException(
                    "Aircraft not found: " + aircraftId
            );
        }

        return aircraft;
    }

    private Aircraft searchAircraftById(String aircraftId) {

        for (int i = 0; i < count; i++) {

            if (aircrafts[i].getAircraftId()
                    .equalsIgnoreCase(aircraftId)) {

                return aircrafts[i];
            }
        }

        return null;
    }

    public Aircraft searchAircraft(String model,
                                   String manufacturer)
            throws AircraftNotFoundException {

        for (int i = 0; i < count; i++) {

            if (aircrafts[i].getModel()
                    .equalsIgnoreCase(model)
                    && aircrafts[i].getManufacturer()
                    .equalsIgnoreCase(manufacturer)) {

                return aircrafts[i];
            }
        }

        throw new AircraftNotFoundException(
                "Aircraft not found for given model and manufacturer."
        );
    }

    public void displayAllAircraft() {

        if (count == 0) {
            System.out.println("No aircraft available.");
            return;
        }

        for (int i = 0; i < count; i++) {

            aircrafts[i].displayDetails();

            System.out.println("-------------------------");
        }
    }
}