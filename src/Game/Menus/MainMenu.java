package Game.Menus;


public class MainMenu extends Menu {

    public MainMenu(){
        setTitle("Main Menu");
    }

    @Override
    public void runMenu() {
        super.runMenu();
        printMenu();
        int chosenMenu = getInput();
        goToMenu(chosenMenu);
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
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
