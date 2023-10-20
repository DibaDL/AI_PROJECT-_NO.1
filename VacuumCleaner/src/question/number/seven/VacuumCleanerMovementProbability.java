package question.number.seven;

import java.util.Random;

public class VacuumCleanerMovementProbability {
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

    public void initialize() {
        setLocationsDirtState();
        setCurrentXAxis();
        setCurrentYAxis();
        setSuckCounter();
        setMoveCounter();
    }

    public void setLocationsDirtState() {
        locationsDirtState = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                locationsDirtState[i][j] = rand.nextInt(2);
            }
        }
    }

    public void setCurrentXAxis() {
        currentXAxis = new Random().nextInt(n);
    }

    public void setCurrentYAxis() {
        currentYAxis = new Random().nextInt(n);
    }

    public void setSuckCounter() {
        suckCounter = 0;
    }

    public void setMoveCounter() {
        moveCounter = 0;
    }

    public int getSuckCounter() {
        return suckCounter;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void suck() {
        this.locationsDirtState[this.currentXAxis][this.currentYAxis] = 0;
        this.suckCounter += 1;
    }

    public boolean move(int deltaX, int deltaY) {
        int newXAxis = this.currentXAxis + deltaX;
        int newYAxis = this.currentYAxis + deltaY;

        if (newXAxis >= 0 && newXAxis < n && newYAxis >= 0 && newYAxis < n) {
            int movementController = moveController();
            System.out.println("Movement controller : " + movementController);
            if (movementController != 0){
                this.currentXAxis = newXAxis;
                this.currentYAxis = newYAxis;
                this.moveCounter += 1;
            }
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
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.locationsDirtState[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int moveController(){
        return new Random().nextInt(5);
    }
}
