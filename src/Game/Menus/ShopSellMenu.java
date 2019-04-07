package Game.Menus;

import Game.Items.Item;
import Game.Player.Player;
import Game.Shop.Shop;
import java.util.ArrayList;

public class ShopSellMenu extends Menu {
    
    private boolean toExitShopSellMenu = false;
    
    public ShopSellMenu() {
        setTitle("Shop Sell");
    }
     
    @Override
    public boolean checkConditions(int a) {
        //todo
        if(a >= 0){
            return true;
        }
        return false;
    }
    
    @Override
    public void printMenu() {
        System.out.println("0 Exit to Town Menu");
        System.out.println("#### ITEMS ####");
        ArrayList<Item> items = Player.getCurrentCharacter().getItemData().getAllInventoryItems();
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).toString());
        }  
        System.out.println("Choose an item from the list above.(Enter the number)");
        System.out.println("You have " + Player.getCurrentCharacter().getMoney() + " gold.");
    }
    
    @Override
    public void goToMenu(int chosenMenu) {
        if(chosenMenu == 0){
            toExitShopSellMenu = true;
        }else{
            Item item = Shop.getItemById(chosenMenu);
            Player.getCurrentCharacter().sellItem(item);
            //Shop.buyItem(item);
        }
    }
    
    @Override
    public int runMenu() {
        Player character = Player.getCurrentCharacter();
        while (!toExitShopSellMenu) {
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
