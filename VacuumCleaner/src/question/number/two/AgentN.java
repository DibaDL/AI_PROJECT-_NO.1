package question.number.two;
import java.util.Random;
import java.util.Scanner;

public class AgentN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        VacuumCleanerN vacuumCleanerN = new VacuumCleanerN();
        vacuumCleanerN.setN(n);
        vacuumCleanerN.setLocationsDirtState();
        vacuumCleanerN.setCurrentXAxis();
        vacuumCleanerN.setCurrentYAxis();
        vacuumCleanerN.setSuckCounter();
        vacuumCleanerN.setMoveCounter();

        while (!vacuumCleanerN.checkHalt()){
            System.out.println("*******************************************************************");
            System.out.println("Current loc : [" + vacuumCleanerN.currentXAxis + "][" + vacuumCleanerN.currentYAxis + "]");
            for (int i = 0; i < vacuumCleanerN.n; i++){
                for (int j = 0; j < vacuumCleanerN.n; j++){
                    if (vacuumCleanerN.locationsDirtState[i][j] == 0){
                        System.out.print("Clean ");
                    }else {
                        System.out.print("Dirty ");
                    }
                }
                System.out.println();
            }
            System.out.println("*******************************************************************");
            System.out.println("In halt loop");
            if (vacuumCleanerN.locationsDirtState[vacuumCleanerN.currentXAxis][vacuumCleanerN.currentYAxis] == 1){
                vacuumCleanerN.suck();
            }
            boolean actionState = false;
            while(!actionState){
                int action = actionController();
                System.out.println("In action state loop");
                if (action == 0){
                    System.out.println("Right");
                    actionState = vacuumCleanerN.moveRight();
                }else if (action == 1){
                    System.out.println("Left");
                    actionState = vacuumCleanerN.moveLeft();
                }else if (action == 2){
                    System.out.println("Up");
                    actionState = vacuumCleanerN.moveUp();
                }else {
                    System.out.println("Down");
                    actionState = vacuumCleanerN.moveDown();
                }
            }

        }
    }

    public static int actionController(){
        Random rand = new Random();
        int action = rand.nextInt(4);
        return action;
    }
}
