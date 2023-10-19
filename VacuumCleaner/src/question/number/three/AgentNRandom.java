package question.number.three;

import question.number.two.VacuumCleanerN;

import java.util.Random;
import java.util.Scanner;

public class AgentNRandom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        VacuumCleanerNRandom vacuumCleanerNRandom = new VacuumCleanerNRandom();
        vacuumCleanerNRandom.setN(n);
        vacuumCleanerNRandom.setLocationsDirtState();
        vacuumCleanerNRandom.setCurrentXAxis();
        vacuumCleanerNRandom.setCurrentYAxis();
        vacuumCleanerNRandom.setSuckCounter();
        vacuumCleanerNRandom.setMoveCounter();

        int counter = 0;
        while (!vacuumCleanerNRandom.checkHalt()){
            System.out.println(counter);
            if (counter % 3 == 2){
                vacuumCleanerNRandom.setLocationsDirtState();
            }
            System.out.println("*******************************************************************");
            System.out.println("Current loc : [" + vacuumCleanerNRandom.currentXAxis + "][" + vacuumCleanerNRandom.currentYAxis + "]");
            for (int i = 0; i < vacuumCleanerNRandom.n; i++){
                for (int j = 0; j < vacuumCleanerNRandom.n; j++){
                    if (vacuumCleanerNRandom.locationsDirtState[i][j] == 0){
                        System.out.print("Clean ");
                    }else {
                        System.out.print("Dirty ");
                    }
                }
                System.out.println();
            }
            System.out.println("*******************************************************************");
            System.out.println("In halt loop");
            if (vacuumCleanerNRandom.locationsDirtState[vacuumCleanerNRandom.currentXAxis][vacuumCleanerNRandom.currentYAxis] == 1){
                vacuumCleanerNRandom.suck();
            }
            boolean actionState = false;
            while(!actionState){
                int action = actionController();
                System.out.println("In action state loop");
                if (action == 0){
                    System.out.println("Right");
                    actionState = vacuumCleanerNRandom.moveRight();
                }else if (action == 1){
                    System.out.println("Left");
                    actionState = vacuumCleanerNRandom.moveLeft();
                }else if (action == 2){
                    System.out.println("Up");
                    actionState = vacuumCleanerNRandom.moveUp();
                }else {
                    System.out.println("Down");
                    actionState = vacuumCleanerNRandom.moveDown();
                }
            }
            counter ++;
            System.out.println("************************************************");
            for (int i = 0; i < vacuumCleanerNRandom.n; i++){
                for (int j = 0; j < vacuumCleanerNRandom.n; j++){
                    if (vacuumCleanerNRandom.locationsDirtState[i][j] == 0){
                        System.out.print("Clean ");
                    }else {
                        System.out.print("Dirty ");
                    }
                }
                System.out.println();
            }
            System.out.println("************************************************");
        }
    }

    public static int actionController(){
        Random rand = new Random();
        int action = rand.nextInt(4);
        return action;
    }

}
