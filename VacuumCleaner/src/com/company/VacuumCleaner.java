package com.company;

import java.util.Random;

public class VacuumCleaner {
    private int currentLocation;
    private boolean aDirtState;
    private boolean bDirtState;
    private Random rand = new Random();

    public void setDirtState(boolean dirtState) {
        if (rand.nextInt(2) == 0) {
            dirtState = false;
        } else {
            dirtState = true;
        }
    }

    public void setCurrentLocation(int location) {
        currentLocation = location;
    }

    public void moveRight() {
        currentLocation = 1;
    }

    public void moveLeft() {
        currentLocation = 0;
    }

    public void suck() {
        if (currentLocation == 0) {
            aDirtState = false;
        } else {
            bDirtState = false;
        }
    }

    public boolean checkHalt() {
        return !aDirtState && !bDirtState;
    }
}
