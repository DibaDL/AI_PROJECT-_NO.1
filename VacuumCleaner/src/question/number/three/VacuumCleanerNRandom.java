package question.number.three;

import java.util.Random;

public class VacuumCleanerNRandom {
    int n;

    int currentXAxis;
    int currentYAxis;
    int[][] locationsDirtState;
    int suckCounter;
    int moveCounter;

    public void setN(int n) {
        this.n = n;
    }

    public void setLocationsDirtState() {
        locationsDirtState = new int[this.n][this.n];
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                Random rand = new Random();
                int state = rand.nextInt(2);
                this.locationsDirtState[i][j] = state;
            }
        }
    }


    public void setCurrentXAxis(){
        Random rand = new Random();
        int x = rand.nextInt(this.n);
        this.currentXAxis = x;
    }

    public void setCurrentYAxis(){
        Random rand = new Random();
        int y = rand.nextInt(this.n);
        this.currentYAxis = y;
    }

    public void setSuckCounter() {
        this.suckCounter = 0;
    }

    public void setMoveCounter() {
        this.moveCounter = 0;
    }

    public void suck(){
        this.suckCounter += 1;
        this.locationsDirtState[this.currentXAxis][this.currentYAxis] = 0;
    }


    public boolean moveRight(){
        boolean done = true;
        if (this.currentYAxis == this.n - 1){
            done = false;
        }else {
            this.currentYAxis += 1;
            this.moveCounter += 1;
        }
        return done;
    }

    public boolean moveLeft(){
        boolean done = true;
        if (this.currentYAxis == 0){
            done = false;
        }else {
            this.currentYAxis -= 1;
            this.moveCounter += 1;
        }
        return done;
    }

    public boolean moveUp(){
        boolean done = true;
        if (this.currentXAxis == 0){
            done = false;
        }else {
            this.currentXAxis -= 1;
            this.moveCounter += 1;
        }
        return done;
    }

    public boolean moveDown(){
        boolean done = true;
        if (this.currentXAxis == n - 1){
            done = false;
        }else {
            this.currentXAxis += 1;
            this.moveCounter += 1;
        }
        return done;
    }

    public boolean checkHalt(){
        boolean halt = true;
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.n; j++){
                if(this.locationsDirtState[i][j] == 1) {
                    halt = false;
                    break;
                }
            }
        }
        return halt;
    }
}
