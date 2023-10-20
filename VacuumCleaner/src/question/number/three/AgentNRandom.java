package question.number.three;

import java.util.Random;
import java.util.Scanner;

public class AgentNRandom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        VacuumCleanerNRandom vacuumCleanerNRandom = new VacuumCleanerNRandom();
        vacuumCleanerNRandom.setN(n);
        vacuumCleanerNRandom.initialize();

        int counter = 0;
        while (!vacuumCleanerNRandom.checkHalt()) {
            System.out.println(counter);
            if (counter % 3 == 2) {
                vacuumCleanerNRandom.setLocationsDirtState();
            }
            printVacuumStatus(vacuumCleanerNRandom);

            int action = actionController();
            performAction(vacuumCleanerNRandom, action);

            counter++;
        }
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static void performAction(VacuumCleanerNRandom vacuumCleaner, int action) {
        System.out.println("In action state loop");
        switch (action) {
            case 0:
                System.out.println("Right");
                vacuumCleaner.moveRight();
                break;
            case 1:
                System.out.println("Left");
                vacuumCleaner.moveLeft();
                break;
            case 2:
                System.out.println("Up");
                vacuumCleaner.moveUp();
                break;
            case 3:
                System.out.println("Down");
                vacuumCleaner.moveDown();
                break;
        }
    }

    public static void printVacuumStatus(VacuumCleanerNRandom vacuumCleaner) {
        System.out.println("*******************************************************************");
        System.out.println("Current loc : [" + vacuumCleaner.getCurrentXAxis() + "][" + vacuumCleaner.getCurrentYAxis() + "]");
        for (int i = 0; i < vacuumCleaner.getN(); i++) {
            for (int j = 0; j < vacuumCleaner.getN(); j++) {
                if (vacuumCleaner.getLocationsDirtState()[i][j] == 0) {
                    System.out.print("Clean ");
                } else {
                    System.out.print("Dirty ");
                }
            }
            System.out.println();
        }
        System.out.println("*******************************************************************");
    }
}