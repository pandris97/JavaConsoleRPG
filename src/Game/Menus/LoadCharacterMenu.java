package Game.Menus;

import java.util.Scanner;

public class LoadCharacterMenu extends Menu{

    public String characterName ="";

    LoadCharacterMenu(){
        setTitle("Load Existing Character");
    }

    @Override
    public void runMenu() {
        super.runMenu();
        printMenu();
    }

    @Override
    public void printMenu() {
        System.out.print("Your character's name: ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
