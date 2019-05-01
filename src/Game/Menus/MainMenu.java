
package Game.Menus;

public class MainMenu extends Menu {

    public CharacterCreationMenu chcMenu = new CharacterCreationMenu();
    public LoadCharacterMenu loadMenu = new LoadCharacterMenu();
    public TownMenu townMenu = new TownMenu();


    public MainMenu(){
        setTitle("Main Menu");
    }

    public boolean toExit=false;

    @Override
    public int runMenu() {
        while (!toExit) {
            super.runMenu();
            printMenu();
            int chosenMenu = getInput();
            goToMenu(chosenMenu);
        }

        return 0;
    }

    @Override
    public void printMenu() {
        System.out.println("1 Create New Character");
        System.out.println("2 Load Character");
        System.out.println("3 Exit Game");
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

    @Override
    public void goToMenu(int chosenMenu) {
        switch (chosenMenu){
            case 1:
                if (!createCharacter())
                    break;

                goToTown();
                townMenu = new TownMenu();
                break;
            case 2:
                if (!loadCharacter())
                    break;

                goToTown();
                townMenu = new TownMenu();
                break;
            case 3:
                toExit = true;
                break;
            default:
                break;
        }
    }

    private boolean loadCharacter() {
        return loadMenu.runMenu() == 0;
    }

    private void goToTown() {
        townMenu.runMenu();
    }

    private boolean createCharacter() {
        return chcMenu.runMenu() == 0;
    }
}
