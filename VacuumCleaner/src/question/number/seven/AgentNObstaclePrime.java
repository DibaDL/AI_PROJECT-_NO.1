package question.number.seven;

import question.number.one.PerformanceMeasure;

import java.util.Random;
import java.util.Scanner;

public class AgentNObstaclePrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long performance = 0;
        for (int k = 0; k < 100; k++) {
            VacuumCleanerNObstaclePrime vacuumCleanerNObstaclePrime = new VacuumCleanerNObstaclePrime();
            vacuumCleanerNObstaclePrime.setN(n);
            vacuumCleanerNObstaclePrime.initialize();
            vacuumCleanerNObstaclePrime.setObstacles();

            while (!vacuumCleanerNObstaclePrime.checkHalt()) {
                printVacuumStatus(vacuumCleanerNObstaclePrime);

                if (vacuumCleanerNObstaclePrime.getLocationsDirtState()[vacuumCleanerNObstaclePrime.getCurrentXAxis()][vacuumCleanerNObstaclePrime.getCurrentYAxis()] == 1) {
                    vacuumCleanerNObstaclePrime.suck();
                }

                boolean actionState = false;
                while (!actionState) {
                    int action = actionController();
                    if (action == 0) {
                        System.out.println("Right");
                        actionState = vacuumCleanerNObstaclePrime.moveRight();
                    } else if (action == 1) {
                        System.out.println("Left");
                        actionState = vacuumCleanerNObstaclePrime.moveLeft();
                    } else if (action == 2) {
                        System.out.println("Up");
                        actionState = vacuumCleanerNObstaclePrime.moveUp();
                    } else {
                        System.out.println("Down");
                        actionState = vacuumCleanerNObstaclePrime.moveDown();
                    }
                }
            }


            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleanerNObstaclePrime.getSuckCounter(), vacuumCleanerNObstaclePrime.getMoveCounter());
            performance += p;
        }
        System.out.println("Performance :" + performance / 100);
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static void printVacuumStatus(VacuumCleanerNObstaclePrime vacuumCleanerNObstaclePrime) {
        System.out.println("*******************************************************************");
        System.out.println("Current loc : [" + vacuumCleanerNObstaclePrime.getCurrentXAxis() + "][" + vacuumCleanerNObstaclePrime.getCurrentYAxis() + "]");
        for (int i = 0; i < vacuumCleanerNObstaclePrime.getN(); i++) {
            for (int j = 0; j < vacuumCleanerNObstaclePrime.getN(); j++) {
                if (vacuumCleanerNObstaclePrime.getLocationsDirtState()[i][j] == 0) {
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
