package Game.Menus;

import Game.Player.Player;

import java.util.Scanner;

public class CharacterCreationMenu extends Menu{

    public String characterName = "";

    CharacterCreationMenu(){
        setTitle("Character Creation");
    }

    @Override
    public int runMenu() {
        super.runMenu();

        boolean characterIsOk;
        do {
            printMenu();

            if (characterName.isEmpty())
                return 1;

            Player character = new Player(characterName);
            String errorString = character.saveToFile(true);

            if (errorString == null) {
                Player.setCurrentCharacter(character);
                characterIsOk = true;
            } else {
                System.out.println("Cannot create character: " + errorString);
                characterIsOk = false;
            }

        } while (!characterIsOk);

        return 0;
    }

    @Override
    public void printMenu() {
        System.out.print("Your character's name (leave empty to cancel): ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
