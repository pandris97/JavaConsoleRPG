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
    public void runMenu() {
        while (!toExit) {
            super.runMenu();
            printMenu();
            int chosenMenu = getInput();
            goToMenu(chosenMenu);
        }
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
                createCharacter();
                goToTown();
                townMenu = new TownMenu();
                break;
            case 2:
                loadCharacter();
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

    private void loadCharacter() {
        loadMenu.runMenu();
    }

    private void goToTown() {
        townMenu.runMenu();
    }

    private void createCharacter() {
        chcMenu.runMenu();
    }
}
