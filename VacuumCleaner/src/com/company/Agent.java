package com.company;

import java.util.Random;

public class Agent {
    public static void main(String[] args) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setaDirtState();
        vacuumCleaner.setbDirtState();
        vacuumCleaner.setCurrentLocation();
        while (!vacuumCleaner.checkHalt()){
            System.out.println("************************************************");
            if (vacuumCleaner.currentLocation == 0){
                System.out.println("Current Location is A");
            }else {
                System.out.println("Current Location is B");
            }
            System.out.println("A dirt state: " + vacuumCleaner.aDirtState);
            System.out.println("B dirt state: " + vacuumCleaner.bDirtState);
            System.out.println("************************************************");

            if (vacuumCleaner.currentLocation == 0){
                System.out.println("Loc is A");
                if (vacuumCleaner.aDirtState){
                    System.out.println("It is dirty");

                    vacuumCleaner.suck();
                    vacuumCleaner.moveRight();
                } else {
                    System.out.println("It is clean");
                    vacuumCleaner.moveRight();
                }
            }else {
                System.out.println("Loc is B");
                if (vacuumCleaner.bDirtState){
                    System.out.println("It is dirty");
                    vacuumCleaner.suck();
                    vacuumCleaner.moveLeft();
                }else {
                    System.out.println("It is clean");
                    vacuumCleaner.moveLeft();
                }
            }

            System.out.println("************************************************");
            if (vacuumCleaner.currentLocation == 0){
                System.out.println("Current Location is A");
            }else {
                System.out.println("Current Location is B");
            }
            System.out.println("A dirt state: " + vacuumCleaner.aDirtState);
            System.out.println("B dirt state: " + vacuumCleaner.bDirtState);
            System.out.println("************************************************");
        }

    }


}
