package question.number.six;

import question.number.one.PerformanceMeasure;

import java.util.Random;
import java.util.Scanner;

public class AgentModelBased {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long performance = 0;
        for (int k = 0; k < 100; k++) {
            VacuumCleanerModelBased vacuumCleanerModelBased = new VacuumCleanerModelBased();
            vacuumCleanerModelBased.setN(n);
            vacuumCleanerModelBased.initialize();
            vacuumCleanerModelBased.setObstacles();

            while (!vacuumCleanerModelBased.checkHalt()) {
                printVacuumStatus(vacuumCleanerModelBased);

                if (vacuumCleanerModelBased.getLocationsDirtState()[vacuumCleanerModelBased.getCurrentXAxis()][vacuumCleanerModelBased.getCurrentYAxis()] == 1) {
                    vacuumCleanerModelBased.suck();
                }

                boolean actionState = false;
                while (!actionState) {
                    int action = actionController();
                    System.out.println("In action state loop");
                    if (action == 0) {
                        System.out.println("Right");
                        actionState = vacuumCleanerModelBased.moveRight();
                    } else if (action == 1) {
                        System.out.println("Left");
                        actionState = vacuumCleanerModelBased.moveLeft();
                    } else if (action == 2) {
                        System.out.println("Up");
                        actionState = vacuumCleanerModelBased.moveUp();
                    } else {
                        System.out.println("Down");
                        actionState = vacuumCleanerModelBased.moveDown();
                    }
                }
            }


            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleanerModelBased.getSuckCounter(), vacuumCleanerModelBased.getMoveCounter());
            performance += p;
            System.out.println("K is " + k + " and p is " + p + ". More details are : SuckCounter: " + vacuumCleanerModelBased.getSuckCounter() + " and MoveCounter : " + vacuumCleanerModelBased.getMoveCounter());
        }
        System.out.println("Performance :" + performance / 100);
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static void printVacuumStatus(VacuumCleanerModelBased vacuumCleanerModelBased) {
        System.out.println("*******************************************************************");
        System.out.println("Current loc : [" + vacuumCleanerModelBased.getCurrentXAxis() + "][" + vacuumCleanerModelBased.getCurrentYAxis() + "]");
        for (int i = 0; i < vacuumCleanerModelBased.getN(); i++) {
            for (int j = 0; j < vacuumCleanerModelBased.getN(); j++) {
                if (vacuumCleanerModelBased.getLocationsDirtState()[i][j] == 0) {
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

