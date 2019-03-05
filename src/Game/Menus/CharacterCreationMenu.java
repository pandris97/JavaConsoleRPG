package Game.Menus;

import java.util.Scanner;

public class CharacterCreationMenu extends Menu{

    public String characterName ="";

    CharacterCreationMenu(){
        setTitle("Character Creation");
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
