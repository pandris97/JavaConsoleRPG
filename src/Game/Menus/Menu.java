package Game.Menus;

import java.io.IOException;
import java.util.Scanner;

public abstract class Menu{

    private String title;

    public Menu(){
        title = "menu";
    }

    public void runMenu(){
        clrscr();
        System.out.println("####################");
        System.out.println(title);
        System.out.println("####################");
        System.out.println();
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void printMenu() {}

    public int getInput() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean isValidNumber = false;
        while (!isValidNumber){
            boolean isNumber = true;
            System.out.print("->");
            try {
                choice = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException e){
                isNumber = false;
                System.out.println("Please type in a number");
            }
            if (isNumber){
                isValidNumber = checkConditions(choice);
            }
        }
        return choice;
    }

    public boolean checkConditions(int a){
        return false;
    }

    public void goToMenu(int chosenMenu){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
