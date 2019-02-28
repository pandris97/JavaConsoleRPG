package Game.Menus;

public abstract class Menu{

    private String title;

    public Menu(){
        title = "menu";
    }

    void printOptions(){
        System.out.println("####################");
        System.out.println(title);
        System.out.println("####################");
        System.out.println();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void chooseOption(){}
}
