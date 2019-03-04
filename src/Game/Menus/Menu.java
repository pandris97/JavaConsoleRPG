package Game.Menus;

import java.util.Scanner;

public abstract class Menu{

    private String title;

    public Menu(){
        title = "menu";
    }

    public void runMenu(){
        System.out.println("####################");
        System.out.println(title);
        System.out.println("####################");
        System.out.println();
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
                System.out.println("Please type in 1, 2 or 3");
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
