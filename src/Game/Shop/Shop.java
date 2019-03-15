package Game.Shop;

import Game.Items.Axe;
import Game.Items.PotionItem;
import Game.Items.Sword;
import Game.Items.WeaponItem;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    
    //POTION AND WEAPON LIST IMPL GOES HERE
   
//    private List<Item> shopItems;
    private static List<WeaponItem> weaponItems = new ArrayList<>();
    private static List<PotionItem> potionItems = new ArrayList<>();
    
    public Shop() {
        initItemList();
    }
    
    private void initItemList(){
        //todo: Init items from file, JSON????
        weaponItems.add(new Sword("Jani", 1500));
        weaponItems.add(new Sword("Bela", 2000));
        weaponItems.add(new Axe("Isti", 200000));
        potionItems.add(new PotionItem("Healing Poti", 1000, 30));
        potionItems.add(new PotionItem("Bigger Poti", 1000, 90));
    }
    
    public static void showItemList(){
        StringBuilder sb = new StringBuilder();
        sb.append("#### WEAPONS ####\n");
        for (int i = 0; i < weaponItems.size(); i++) {
            sb.append((i + 1) + " " + weaponItems.get(i).toString() + "\n");
        }
        sb.append("#### POTIONS ####\n");
        for (int i = 0; i < potionItems.size(); i++) {
            sb.append((weaponItems.size() + i + 1) + " " + potionItems.get(i).toString() + "\n");
        }
        System.out.println(sb.toString());
    } 
    
    
    
    
}
