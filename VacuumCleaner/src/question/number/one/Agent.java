package question.number.one;

import question.number.one.VacuumCleaner;

public class Agent {
    public static void main(String[] args) {
        long performance = 0;
        for (int k = 0; k < 100; k++){
            VacuumCleaner vacuumCleaner = new VacuumCleaner();
            vacuumCleaner.setaDirtState();
            vacuumCleaner.setbDirtState();
            vacuumCleaner.setCurrentLocation();
            vacuumCleaner.setSuckCounter();
            vacuumCleaner.setMoveCounter();

            while (!vacuumCleaner.checkHalt()) {
                printStatus(vacuumCleaner);

                if (vacuumCleaner.currentLocation == 0) {
                    cleanLocation(vacuumCleaner, vacuumCleaner.aDirtState);
                    vacuumCleaner.moveRight();
                } else {
                    cleanLocation(vacuumCleaner, vacuumCleaner.bDirtState);
                    vacuumCleaner.moveLeft();
                }

                printStatus(vacuumCleaner);
            }
            PerformanceMeasure performanceMeasure = new PerformanceMeasure();
            int p = performanceMeasure.performanceMeasureCalc(vacuumCleaner.suckCounter, vacuumCleaner.moveCounter);
            performance += p;
            System.out.println("K is " + k + " and p is " + p + ". More details are : SuckCounter: " + vacuumCleaner.suckCounter + " and MoveCounter : " + vacuumCleaner.moveCounter);
        }
        System.out.println("Performance :" + performance / 100);
    }

    private static void cleanLocation(VacuumCleaner vacuumCleaner, boolean dirtState) {
        if (dirtState) {
            System.out.println("It is dirty");
            vacuumCleaner.suck();
        } else {
            System.out.println("It is clean");
        }
    }

    private static void printStatus(VacuumCleaner vacuumCleaner) {
        System.out.println("************************************************");
        System.out.println("Current Location is " + (vacuumCleaner.currentLocation == 0 ? "A" : "B"));
        System.out.println("A dirt state: " + vacuumCleaner.aDirtState);
        System.out.println("B dirt state: " + vacuumCleaner.bDirtState);
        System.out.println("************************************************");
    }
}
