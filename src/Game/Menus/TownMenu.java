package Game.Menus;

import Game.Player.Player;
import Game.Adventure.Adventure;

public class TownMenu extends Menu{

    private boolean toExitTown = false;

    TownMenu(){
        setTitle("Blight Town");
    }

    @Override
    public int runMenu() {
        Player character = Player.getCurrentCharacter();

        while (!toExitTown) {
            super.runMenu();
            System.out.println("Gold: " + character.getMoney() + "g");
            System.out.println("XP: " + character.getExperience() + "xp/" + character.getExperienceForNextLevel());
            System.out.println("Character level: " + character.getLevel());
            System.out.println("Health: " + character.getStats().getCurrentHealth() + "/" + character.getStats().getMaxHealth());
            printMenu();
            int chosenMenu2 = getInput();
            goToMenu(chosenMenu2);
        }

        character.saveToFile(false);

        return 0;
    }

    @Override
    public void printMenu() {
        System.out.println("1 Adventure");
        System.out.println("2 Shop");
        System.out.println("3 Rest");
        System.out.println("4 Exit to Main Menu");
    }

    public boolean checkConditions(int a) {
        boolean isValid;
        if(a<6 && 0<a){
            isValid = true;
        } else {
            isValid=false;
            System.out.println("Please type in 1, 2 or 3");
        }
        return isValid;
    }

    @Override
    public void goToMenu(int chosenMenu2) {
        Player character = Player.getCurrentCharacter();
        switch (chosenMenu2){
            case 1:
                Adventure adventure = new Adventure(character);
                adventure.doAdventure();
                break;
            case 2:
                character.spendMoney(1);
                break;
            case 3:
                character.restoreHealth(1);
                character.spendMoney(1);
                break;
            case 4:
                toExitTown = true;
                break;
            default:
                toExitTown = false;
                break;
        }
    }
}
