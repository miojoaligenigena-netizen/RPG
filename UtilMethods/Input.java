package UtilMethods;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    
    public int inputInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again");
                scanner.next();
            }
        }
    }
    
    public String inputString() {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Try again");
                scanner.next();
            }
        }
    }
    
    public int inputChoise(int range){
        while (true){
            int num = this.inputInt();
            if (choiseInRange(num, range)) {
                return num;
            } else {
                System.out.println("Invalid choise");
            }
        }
    }
    
    public boolean choiseInRange(int var, int range){
        return 1 <= var && var <= range;
    }
}
