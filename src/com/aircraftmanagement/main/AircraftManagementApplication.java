package com.aircraftmanagement.main;
import java.util.Scanner;
import com.aircraftmanagement.exception.AircraftAlreadyExistsException;
import com.aircraftmanagement.exception.AircraftNotFoundException;
import com.aircraftmanagement.exception.FlightNotFoundException;
import com.aircraftmanagement.exception.InvalidFlightException;
import com.aircraftmanagement.exception.PilotAlreadyAssignedException;
import com.aircraftmanagement.exception.PilotNotFoundException;
import com.aircraftmanagement.model.Aircraft;
import com.aircraftmanagement.model.CargoAircraft;
import com.aircraftmanagement.model.Flight;
import com.aircraftmanagement.model.PassengerAircraft;
import com.aircraftmanagement.model.Pilot;
import com.aircraftmanagement.model.PrivateAircraft;
import com.aircraftmanagement.service.AircraftManager;
import com.aircraftmanagement.service.FlightManager;
import com.aircraftmanagement.service.PilotManager;
public class AircraftManagementApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static AircraftManager aircraftManager =
            new AircraftManager(10);
    private static PilotManager pilotManager =
            new PilotManager(10);
    private static FlightManager flightManager =
            new FlightManager(10);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: registerAircraft();
                    break;
                    case 2: aircraftManager.displayAllAircraft();
                    break;
                    case 3: searchAircraft();
                    break;
                    case 4: addPilot();
                    break;
                    case 5: pilotManager.displayAllPilots();
                    break;
                    case 6: searchPilot();
                    break;
                    case 7: scheduleFlight();
                    break;
                    case 8: flightManager.displayAllFlights();
                    break;
                    case 9: searchFlight();
                    break;
                    case 10: cancelFlight();
                    break;
                    case 0: System.out.println("Exiting Aircraft Management System...");
                    break;
                    default: System.out.println("Invalid menu choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                choice = -1;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("======================================");
        System.out.println("      AIRCRAFT MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Register Aircraft");
        System.out.println("2. Display All Aircraft");
        System.out.println("3. Search Aircraft");
        System.out.println("4. Add Pilot");
        System.out.println("5. Display All Pilots");
        System.out.println("6. Search Pilot");
        System.out.println("7. Schedule Flight");
        System.out.println("8. Display All Flights");
        System.out.println("9. Search Flight");
        System.out.println("10. Cancel Flight");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void registerAircraft() {
        try {
            System.out.print("Enter Aircraft ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Enter Capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine());
            System.out.println();
            System.out.println("Select Aircraft Type:");
            System.out.println("1. Passenger");
            System.out.println("2. Cargo");
            System.out.println("3. Private");
            System.out.print("Enter type: ");
            int type = Integer.parseInt(scanner.nextLine());
            Aircraft aircraft;
            switch (type) {
                case 1: System.out.print("Enter Number of Passengers: ");
                    int passengers = Integer.parseInt(scanner.nextLine());

                    System.out.print(
                            "Business Class Available (true/false): "
                    );

                    boolean business =
                            Boolean.parseBoolean(
                                    scanner.nextLine()
                            );

                    aircraft = new PassengerAircraft(
                            id,
                            model,
                            manufacturer,
                            capacity,
                            passengers,
                            business
                    );

                    break;

                case 2:

                    System.out.print(
                            "Enter Cargo Capacity: "
                    );

                    double cargoCapacity =
                            Double.parseDouble(scanner.nextLine());

                    System.out.print(
                            "Enter Cargo Type: "
                    );

                    String cargoType =
                            scanner.nextLine();

                    aircraft = new CargoAircraft(
                            id,
                            model,
                            manufacturer,
                            capacity,
                            cargoCapacity,
                            cargoType
                    );

                    break;

                case 3:

                    System.out.print(
                            "Enter Owner Name: "
                    );

                    String ownerName =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Luxury Level: "
                    );

                    String luxuryLevel =
                            scanner.nextLine();

                    aircraft = new PrivateAircraft(
                            id,
                            model,
                            manufacturer,
                            capacity,
                            ownerName,
                            luxuryLevel
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid aircraft type."
                    );

                    return;
            }

            aircraftManager.registerAircraft(aircraft);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid numeric input."
            );

        } catch (AircraftAlreadyExistsException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void searchAircraft() {

        try {

            System.out.print("Enter Aircraft ID: ");

            String id = scanner.nextLine();

            Aircraft aircraft =
                    aircraftManager.searchAircraft(id);

            aircraft.displayDetails();

        } catch (AircraftNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void addPilot() {

        try {

            System.out.print("Enter Pilot ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Pilot Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter License Number: ");
            String license = scanner.nextLine();

            System.out.print("Enter Experience: ");

            int experience =
                    Integer.parseInt(scanner.nextLine());

            Pilot pilot = new Pilot(
                    id,
                    name,
                    license,
                    experience
            );

            pilotManager.addPilot(pilot);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Experience must be a number."
            );

        } catch (PilotAlreadyAssignedException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void searchPilot() {

        try {

            System.out.print("Enter Pilot ID: ");

            String id = scanner.nextLine();

            Pilot pilot =
                    pilotManager.searchPilot(id);

            pilot.displayDetails();

        } catch (PilotNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void scheduleFlight() {

        try {

            System.out.print("Enter Flight ID: ");
            String flightId = scanner.nextLine();

            System.out.print("Enter Source: ");
            String source = scanner.nextLine();

            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();

            System.out.print("Enter Aircraft ID: ");
            String aircraftId = scanner.nextLine();

            System.out.print("Enter Pilot ID: ");
            String pilotId = scanner.nextLine();

            Aircraft aircraft =
                    aircraftManager.searchAircraft(aircraftId);

            Pilot pilot =
                    pilotManager.searchPilot(pilotId);

            flightManager.scheduleFlight(
                    flightId,
                    source,
                    destination,
                    aircraft,
                    pilot
            );

        } catch (AircraftNotFoundException |
                 PilotNotFoundException |
                 InvalidFlightException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void searchFlight() {

        try {

            System.out.print("Enter Flight ID: ");

            String id = scanner.nextLine();

            Flight flight =
                    flightManager.searchFlight(id);

            flight.displayDetails();

        } catch (FlightNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void cancelFlight() {

        try {

            System.out.print("Enter Flight ID: ");

            String id = scanner.nextLine();

            flightManager.cancelFlight(id);

        } catch (FlightNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}