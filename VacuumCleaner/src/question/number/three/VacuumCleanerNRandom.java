package question.number.three;

import java.util.Random;

public class VacuumCleanerNRandom {
    private int n;
    private int currentXAxis;
    private int currentYAxis;
    private int[][] locationsDirtState;
    private int suckCounter;
    private int moveCounter;

    public int getN() {
        return n;
    }

    public int getCurrentXAxis() {
        return currentXAxis;
    }

    public int getCurrentYAxis() {
        return currentYAxis;
    }

    public int[][] getLocationsDirtState() {
        return locationsDirtState;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getSuckCounter() {
        return suckCounter;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void initialize() {
        setLocationsDirtState();
        setCurrentXAxis();
        setCurrentYAxis();
        setSuckCounter();
        setMoveCounter();
    }

    public void setLocationsDirtState() {
        locationsDirtState = new int[this.n][this.n];
        Random rand = new Random();
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                locationsDirtState[i][j] = rand.nextInt(2);
            }
        }
    }

    public void setCurrentXAxis() {
        currentXAxis = new Random().nextInt(this.n);
    }

    public void setCurrentYAxis() {
        currentYAxis = new Random().nextInt(this.n);
    }

    public void setSuckCounter() {
        suckCounter = 0;
    }

    public void setMoveCounter() {
        moveCounter = 0;
    }

    public void suck() {
        this. suckCounter += 1;
        locationsDirtState[currentXAxis][currentYAxis] = 0;
    }

    public boolean move(int deltaX, int deltaY) {
        int newXAxis = this.currentXAxis + deltaX;
        int newYAxis = this.currentYAxis + deltaY;

        if (newXAxis >= 0 && newXAxis < n && newYAxis >= 0 && newYAxis < n) {
            this.currentXAxis = newXAxis;
            this.currentYAxis = newYAxis;
            this.moveCounter += 1;
            return true;
        }

        return false;
    }

    public boolean moveRight() {
        return move(0, 1);
    }

    public boolean moveLeft() {
        return move(0, -1);
    }

    public boolean moveUp() {
        return move(-1, 0);
    }

    public boolean moveDown() {
        return move(1, 0);
    }

    public boolean checkHalt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.locationsDirtState[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
