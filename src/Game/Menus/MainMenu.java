package Game.Menus;

public class MainMenu extends Menu {

    public MainMenu(){
        setTitle("Main Menu");

    }

    @Override
    public void printOptions() {
        super.printOptions();
        System.out.println("1 Create New Character");
        System.out.println("2 Load Character");
        System.out.println("3 Exit Game");
    }

    @Override
    public void chooseOption() {
        super.chooseOption();
    }
}
