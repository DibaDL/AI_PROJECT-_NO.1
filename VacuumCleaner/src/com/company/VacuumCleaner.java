package com.company;

import java.util.Random;

public class VacuumCleaner {
    int currentLocation;
    boolean aDirtState;
    boolean bDirtState;


    public void setaDirtState(){
        Random rand = new Random();
        int state = rand.nextInt(2);
        if (state == 0){
            this.aDirtState = false;
        }else {
            this.aDirtState = true;
        }
    }

    public void setbDirtState(){
        Random rand = new Random();
        int state = rand.nextInt(2);
        if (state == 0){
            this.bDirtState = false;
        }else {
            this.bDirtState = true;
        }
    }

    public void setCurrentLocation(){
        Random rand = new Random();
        int location = rand.nextInt(2);
        this.currentLocation = location;
    }

    public void moveRight(){
        this.currentLocation = 1;
    }

    public void moveLeft(){
        this.currentLocation = 0;
    }

    public void suck(){
        if (this.currentLocation == 0){
            this.aDirtState = false;
        }else {
            this.bDirtState = false;
        }
    }

    public boolean checkHalt(){
        boolean halt = false;
        if (!aDirtState && !bDirtState){
            halt = true;
        }
        return halt;
    }
}
