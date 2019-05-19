package Game.Menus;

import Game.Adventure.Adventure;
import Game.Player.Player;

public class AdventureMenu extends Menu {
   AdventureMenu(){
        setTitle("Adventure");
   }

    private boolean adventureIsOver = false;
    private Adventure adventure;

    @Override
    public int runMenu() {
        while (!adventureIsOver) {
            super.runMenu();
            printMenu();
            int chosenMenu = getInput();
            goToMenu(chosenMenu);
        }
        return 0;
    }

    @Override
    public void printMenu() {

        this.adventure = new Adventure();
        System.out.println(adventure.getEnemy());
        System.out.println("1 Fight (Fight a monster)");
        System.out.println("2 Flee (and lose 20 health");
    }

    @Override
    public void goToMenu(int chosenMenu) {
        switch (chosenMenu){
           case 1:
                adventure.doAdventure();
                adventureIsOver = true;
                break;
            case 2:
                Player player = Player.getCurrentCharacter();
                player.getStats().setCurrentHealth(player.getStats().getCurrentHealth()-20);
                adventureIsOver = true;
                break;
            default:
                adventureIsOver = false;
                break;
        }
    }

    @Override
    public boolean checkConditions(int a) {
        boolean isValid;
        if(a<4 && 0<a){
            isValid = true;
        } else {
            isValid=false;
            System.out.println("Please type in 1, 2 or 3");
        }
        return isValid;
    }
}
