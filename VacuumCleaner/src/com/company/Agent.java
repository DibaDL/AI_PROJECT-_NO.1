package com.company;

public class Agent {
    public static void main(String[] args) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setDirtState(vacuumCleaner.aDirtState);
        vacuumCleaner.setDirtState(vacuumCleaner.bDirtState);
        vacuumCleaner.setCurrentLocation(vacuumCleaner.currentLocation);

        while (!vacuumCleaner.checkHalt()) {
            printStatus(vacuumCleaner);

            if (vacuumCleaner.currentLocation == 0) {
                cleanLocation(vacuumCleaner, vacuumCleaner.aDirtState);
                vacuumCleaner.moveRight();
            } else {
                cleanLocation(vacuumCleaner, vacuumCleaner.bDirtState);
                vacuumCleaner.moveLeft();
            }

            printStatus(vacuumCleaner);
        }
    }

    private static void cleanLocation(VacuumCleaner vacuumCleaner, boolean dirtState) {
        if (dirtState) {
            System.out.println("It is dirty");
            vacuumCleaner.suck();
        } else {
            System.out.println("It is clean");
        }
    }

    private static void printStatus(VacuumCleaner vacuumCleaner) {
        System.out.println("************************************************");
        System.out.println("Current Location is " + (vacuumCleaner.currentLocation == 0 ? "A" : "B"));
        System.out.println("A dirt state: " + vacuumCleaner.aDirtState);
        System.out.println("B dirt state: " + vacuumCleaner.bDirtState);
        System.out.println("************************************************");
    }
}
