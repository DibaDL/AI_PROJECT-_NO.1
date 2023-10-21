package question.number.eight;

import java.util.Random;
import java.util.Scanner;
import question.number.one.PerformanceMeasure;

public class AgentProbability {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long performance = 0;
        for (int k = 0; k < 100; k++){
            VacuumCleanerProbability vacuumCleanerN = new VacuumCleanerProbability();
            vacuumCleanerN.setN(n);
            vacuumCleanerN.initialize();

            while (!vacuumCleanerN.checkHalt()) {
                printVacuumStatus(vacuumCleanerN);
                boolean isItDirty = false;
                if (vacuumCleanerN.getLocationsDirtState()[vacuumCleanerN.getCurrentXAxis()][vacuumCleanerN.getCurrentYAxis()] == 1){
                    isItDirty = true;
                }
                int sensorProb = sensorController();
                if (sensorProb == 0){
                    isItDirty = !isItDirty;
                }
                if (isItDirty) {
                    int prob = actionController();
                    if (prob!= 0){
                        vacuumCleanerN.suck();
                    }
                }else {
                    int prob = actionController();
                    if (prob == 0){
                        vacuumCleanerN.makeDirt();
                    }
                }

                boolean actionState = false;
                while (!actionState) {
                    int action = actionController();
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
            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleanerN.getSuckCounter(), vacuumCleanerN.getMoveCounter());
            performance += p;
        }
        System.out.println("Performance :" + performance / 100);
    }

    public static int actionController() {
        return new Random().nextInt(4);
    }

    public static int sensorController(){ return new Random().nextInt(10);}

    public static void printVacuumStatus(VacuumCleanerProbability vacuumCleaner) {
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