package question.number.two;

import java.util.Random;
import java.util.Scanner;

public class AgentN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        VacuumCleanerN vacuumCleanerN = new VacuumCleanerN();
        vacuumCleanerN.setN(n);
        vacuumCleanerN.initialize();

        while (!vacuumCleanerN.checkHalt()) {
            printVacuumStatus(vacuumCleanerN);

            if (vacuumCleanerN.getLocationsDirtState()[vacuumCleanerN.getCurrentXAxis()][vacuumCleanerN.getCurrentYAxis()] == 1) {
                vacuumCleanerN.suck();
            }

            boolean actionState = false;
            while (!actionState) {
                int action = actionController();
                System.out.println("In action state loop");
                if (action == 0) {
                    System.out.println("Right");
                    actionState = vacuumCleanerN.moveRight();
                } else if (action == 1) {
                    System.out.println("Left");
                    actionState = vacuumCleanerN.moveLeft();
                } else if (action == 2) {
                    System.out.println("Up");
                    actionState = vacuumCleanerN.moveUp();
                } else {
                    System.out.println("Down");
                    actionState = vacuumCleanerN.moveDown();
                }
            }
        }
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static void printVacuumStatus(VacuumCleanerN vacuumCleaner) {
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