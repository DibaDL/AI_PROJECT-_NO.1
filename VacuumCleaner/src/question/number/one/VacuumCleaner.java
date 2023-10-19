package question.number.one;

import java.util.Random;

public class VacuumCleaner {
     int currentLocation;
     boolean aDirtState;
     boolean bDirtState;
     int suckCounter;
     int moveCounter;
     Random rand = new Random();

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

    public void setSuckCounter() {
        this.suckCounter = 0;
    }

    public void setMoveCounter() {
        this.moveCounter = 0;
    }

    public void moveRight() {
        currentLocation = 1;
        this.moveCounter += 1;
    }

    public void moveLeft() {
        currentLocation = 0;
        this.moveCounter += 1;
    }

    public void suck() {
        if (currentLocation == 0) {
            aDirtState = false;
        } else {
            bDirtState = false;
        }
        this.suckCounter += 1;
    }

    public boolean checkHalt() {
        return !aDirtState && !bDirtState;
    }
}
