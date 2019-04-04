
package Game.Menus;

import Game.Player.Player;

import java.util.Scanner;

public class LoadCharacterMenu extends Menu{

    public String characterName = "";

    LoadCharacterMenu(){
        setTitle("Load Existing Character");
    }

    @Override
    public int runMenu() {
        super.runMenu();

        boolean fileExists;
        do {
            printMenu();

            if (characterName.isEmpty())
                return 1;

            Player character = Player.loadFromFile(characterName);

            if (character == null) {
                fileExists = false;
                System.out.println("Cannot load this character");
            } else {
                fileExists = true;
                Player.setCurrentCharacter(character);
            }
        } while (!fileExists);

        return 0;
    }

    @Override
    public void printMenu() {
        System.out.print("Your character's name (leave empty to cancel): ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
