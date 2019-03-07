package Game.Menus;

import Game.Player.Player;

import java.util.Scanner;

public class CharacterCreationMenu extends Menu{

    public String characterName = "";

    CharacterCreationMenu(){
        setTitle("Character Creation");
    }

    @Override
    public void runMenu() {
        super.runMenu();

        boolean characterIsOk;
        do {
            printMenu();

            if (characterName.isEmpty()) {
                System.out.println("Character name cannot be empty");
                characterIsOk = false;
                continue;
            }

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
    }

    @Override
    public void printMenu() {
        System.out.print("Your character's name: ");
        Scanner in = new Scanner(System.in);
        characterName = in.nextLine();
    }
}
