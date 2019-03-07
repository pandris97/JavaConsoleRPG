package Game.Menus;

import Game.Player.Player;

import java.util.Scanner;

public class LoadCharacterMenu extends Menu{

    public String characterName = "";

    LoadCharacterMenu(){
        setTitle("Load Existing Character");
    }

    @Override
    public void runMenu() {
        super.runMenu();

        boolean fileExists;
        do {
            printMenu();

            if (characterName.isEmpty()) {
                fileExists = false;
                System.out.println("Character name cannot be empty");
                continue;
            }

            Player character = Player.loadFromFile(characterName);

            if (character == null) {
                fileExists = false;
                System.out.println("Cannot load this character");
            } else {
                fileExists = true;
                Player.setCurrentCharacter(character);
            }
        } while (!fileExists);
    }

    @Override
    public void printMenu() {
        System.out.print("Your character's name: ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
