package Game.Menus;

public class TownMenu extends Menu{

    public int gold = 0;
    public int currXp = 0;
    public int xpToLevelUP = 10;
    public int playerLvl=1;
    public int HP = 100;

    private boolean toExitTown = false;

    TownMenu(){
        setTitle("Blight Town");
    }

    @Override
    public void runMenu() {
        while (!toExitTown) {
            super.runMenu();
            System.out.println("Gold: " + gold + "g");
            System.out.println("XP:" + currXp + "xp/" + xpToLevelUP);
            System.out.println("Character level: " + playerLvl);
            System.out.println("Health: " + HP);
            printMenu();
            int chosenMenu2 = getInput();
            goToMenu(chosenMenu2);
        }
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
        switch (chosenMenu2){
            case 1:
                currXp++;
                gold++;
                HP--;
                break;
            case 2:
                gold--;
                break;
            case 3:
                HP++;
                gold--;
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
