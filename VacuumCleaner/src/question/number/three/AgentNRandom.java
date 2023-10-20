package question.number.three;

import java.util.Random;
import java.util.Scanner;
import question.number.one.PerformanceMeasure;

public class AgentNRandom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long performance = 0;
        for (int k = 0; k < 100; k++){
            VacuumCleanerNRandom vacuumCleanerNRandom = new VacuumCleanerNRandom();
            vacuumCleanerNRandom.setN(n);
            vacuumCleanerNRandom.initialize();
            int counter = 0;
            while (!vacuumCleanerNRandom.checkHalt()) {

                System.out.println("Counter : " + counter);
                if (counter % 3 == 2) {
                    vacuumCleanerNRandom.setLocationsDirtState();
                }

                printVacuumStatus(vacuumCleanerNRandom);

                if (vacuumCleanerNRandom.getLocationsDirtState()[vacuumCleanerNRandom.getCurrentXAxis()][vacuumCleanerNRandom.getCurrentYAxis()] == 1) {
                    vacuumCleanerNRandom.suck();
                }

                boolean actionState = false;
                while (!actionState) {
                    int action = actionController();
                    System.out.println("In action state loop");
                    if (action == 0) {
                        System.out.println("Right");
                        actionState = vacuumCleanerNRandom.moveRight();
                    } else if (action == 1) {
                        System.out.println("Left");
                        actionState = vacuumCleanerNRandom.moveLeft();
                    } else if (action == 2) {
                        System.out.println("Up");
                        actionState = vacuumCleanerNRandom.moveUp();
                    } else {
                        System.out.println("Down");
                        actionState = vacuumCleanerNRandom.moveDown();
                    }
                }
            }
            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleanerNRandom.getSuckCounter(), vacuumCleanerNRandom.getMoveCounter());
            performance += p;
            System.out.println("K is " + k + " and p is " + p + ". More details are : SuckCounter: " + vacuumCleanerNRandom.getSuckCounter() + " and MoveCounter : " + vacuumCleanerNRandom.getMoveCounter());
        }
        System.out.println("Performance :" + performance / 100);
    }

    public static int actionController() {
        return new Random().nextInt(4);
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