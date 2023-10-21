package question.number.five;

import question.number.one.PerformanceMeasure;

import java.util.Random;
import java.util.Scanner;

public class AgentNObstacle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long performance = 0;
        for (int k = 0; k < 100; k++) {
            VacuumCleanerNObstacle vacuumCleanerNObstacle = new VacuumCleanerNObstacle();
            vacuumCleanerNObstacle.setN(n);
            vacuumCleanerNObstacle.initialize();
            vacuumCleanerNObstacle.setObstacles();

            while (!vacuumCleanerNObstacle.checkHalt()) {
                printVacuumStatus(vacuumCleanerNObstacle);

                if (vacuumCleanerNObstacle.getLocationsDirtState()[vacuumCleanerNObstacle.getCurrentXAxis()][vacuumCleanerNObstacle.getCurrentYAxis()] == 1) {
                    vacuumCleanerNObstacle.suck();
                }

                boolean actionState = false;
                while (!actionState) {
                    int action = actionController();
                    if (action == 0) {
                        System.out.println("Right");
                        actionState = vacuumCleanerNObstacle.moveRight();
                    } else if (action == 1) {
                        System.out.println("Left");
                        actionState = vacuumCleanerNObstacle.moveLeft();
                    } else if (action == 2) {
                        System.out.println("Up");
                        actionState = vacuumCleanerNObstacle.moveUp();
                    } else {
                        System.out.println("Down");
                        actionState = vacuumCleanerNObstacle.moveDown();
                    }
                }
            }


            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleanerNObstacle.getSuckCounter(), vacuumCleanerNObstacle.getMoveCounter());
            performance += p;
        }
        System.out.println("Performance :" + performance / 100);
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static void printVacuumStatus(VacuumCleanerNObstacle vacuumCleanerNObstacle) {
        System.out.println("*******************************************************************");
        System.out.println("Current loc : [" + vacuumCleanerNObstacle.getCurrentXAxis() + "][" + vacuumCleanerNObstacle.getCurrentYAxis() + "]");
        for (int i = 0; i < vacuumCleanerNObstacle.getN(); i++) {
            for (int j = 0; j < vacuumCleanerNObstacle.getN(); j++) {
                if (vacuumCleanerNObstacle.getLocationsDirtState()[i][j] == 0) {
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
