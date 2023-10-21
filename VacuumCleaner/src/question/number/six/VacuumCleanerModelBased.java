package question.number.six;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * In the context of the above code for a vacuum cleaner simulation,
 * a "model" refers to a simplified representation of a vacuum cleaner and its environment,
 * which includes the following components:
 * <p>
 * n: An integer representing the size of the square grid (N*N) in which the vacuum cleaner operates.
 * <p>
 * matrix: A 2D integer array that represents the grid,
 * with each cell containing a value (0true or false, in this case, to indicate clean or dirty).
 * <p>
 * position: An array of two integers representing the current position of the vacuum cleaner
 * in the grid, with the first element indicating the row and the second element indicating the column.
 * <p>
 * The VacuumCleaner class provides methods to manipulate this model,
 * allowing the vacuum cleaner to move left, right, up, and down within the grid, clean the cell it's positioned on,
 * and display the state of the grid and also have some obstacles od its grid.
 * <p>
 * The model-based approach here simplifies the vacuum cleaner's behavior within the grid and can serve as
 * a foundation for more advanced features, such as obstacle detection, path planning, and more realistic
 * simulations of a robotic vacuum cleaner.
 */
public class VacuumCleanerModelBased {
    private int n;
    private int currentXAxis;
    private int currentYAxis;
    private int[][] locationsDirtState;
    private int suckCounter;
    private int moveCounter;
    private Map<Integer, Integer> obstacles;

    public void setObstacles() {
        obstacles = new HashMap<>();
        for (int i = 0; i < n / 2; i++) {
            Random rand = new Random();
            int x = rand.nextInt(n);
            int y = rand.nextInt(n);
            obstacles.put(x, y);
        }
    }

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

        if (newXAxis >= 0 && newXAxis < n && newYAxis >= 0 && newYAxis < n && !existsObstacle(newXAxis, newYAxis)) {
            this.currentXAxis = newXAxis;
            this.currentYAxis = newYAxis;
            this.moveCounter += 1;
            return true;
        } else if (existsObstacle(newXAxis, newYAxis)) {
            this.moveCounter += 1;
        }

        return false;
    }

    private boolean existsObstacle(int xAxis, int yAxis) {
        return obstacles.containsKey(xAxis) && obstacles.get(xAxis) == yAxis;
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
}

