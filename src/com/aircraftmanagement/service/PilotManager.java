package com.aircraftmanagement.service;

import com.aircraftmanagement.exception.PilotAlreadyAssignedException;
import com.aircraftmanagement.exception.PilotNotFoundException;
import com.aircraftmanagement.model.Pilot;

public class PilotManager {

    private Pilot[] pilots;
    private int count;

    public PilotManager(int size) {
        pilots = new Pilot[size];
        count = 0;
    }

    public void addPilot(Pilot pilot)
            throws PilotAlreadyAssignedException {

        if (count == pilots.length) {
            throw new IllegalStateException(
                    "Pilot storage is full."
            );
        }

        if (searchPilotById(pilot.getPilotId()) != null) {
            throw new PilotAlreadyAssignedException(
                    "Pilot ID already exists: "
                            + pilot.getPilotId()
            );
        }

        if (pilot.getExperience() < 0) {
            throw new IllegalArgumentException(
                    "Experience cannot be negative."
            );
        }

        pilots[count] = pilot;
        count++;

        System.out.println("Pilot added successfully.");
    }

    public Pilot searchPilot(String pilotId)
            throws PilotNotFoundException {

        Pilot pilot = searchPilotById(pilotId);

        if (pilot == null) {
            throw new PilotNotFoundException(
                    "Pilot not found: " + pilotId
            );
        }

        return pilot;
    }

    private Pilot searchPilotById(String pilotId) {

        for (int i = 0; i < count; i++) {

            if (pilots[i].getPilotId()
                    .equalsIgnoreCase(pilotId)) {

                return pilots[i];
            }
        }

        return null;
    }

    public void displayAllPilots() {

        if (count == 0) {
            System.out.println("No pilots available.");
            return;
        }

        for (int i = 0; i < count; i++) {

            pilots[i].displayDetails();

            System.out.println("-------------------------");
        }
    }
}