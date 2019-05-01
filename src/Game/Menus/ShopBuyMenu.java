package Game.Menus;

import Game.Items.Item;
import Game.Player.Player;
import Game.Shop.Shop;

public class ShopBuyMenu extends Menu {
    
    private boolean toExitShopBuyMenu = false;
    
    public ShopBuyMenu() {
        setTitle("Shop Buy");
    }

    @Override
    public boolean checkConditions(int a) {
        if(a >= 0){
            return true;
        }
        return false;
    }

    @Override
    public void printMenu() {
        System.out.println("0 Exit to Town Menu");
        Shop.showItemList();
        System.out.println("Choose an item from the list above.(Enter the number)");
        System.out.println("You have " + Player.getCurrentCharacter().getMoney() + " gold.");
    }

    @Override
    public void goToMenu(int chosenMenu) {
        if(chosenMenu == 0){
            toExitShopBuyMenu = true;
        }else{
            Item item = Shop.getItemById(chosenMenu);
             if(Player.getCurrentCharacter().buyItem(item)){
                //Shop.sellItem(item);
                System.out.println("Successful buying.");
            }else{
                System.out.println("Unsuccessful bying. You have not enough money!");
            } 
        }
    }
    
    @Override
    public int runMenu() {
        Player character = Player.getCurrentCharacter();
        while (!toExitShopBuyMenu) {
            super.runMenu();
            printMenu();
            int chosenMenu4 = getInput();
            if(checkConditions(chosenMenu4)){
                goToMenu(chosenMenu4);
            } 
        }
    //        character.saveToFile(false);
        return 0;
    }
    
    
    
    
}
