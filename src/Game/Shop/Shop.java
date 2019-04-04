package Game.Shop;

import Game.Items.*;
import Util.JSON.Json;
import Util.JSON.JsonArray;
import Util.JSON.JsonObject;
import Util.JSON.JsonValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    
    //POTION AND WEAPON LIST IMPL GOES HERE
   
//    private List<Item> shopItems;
    private static List<WeaponItem> weaponItems = new ArrayList<>();
    private static List<PotionItem> potionItems = new ArrayList<>();
    
    public Shop() {
        initItemList();
    }
    
    private void initItemList(){
        Scanner scanner = new Scanner(getClass().getResourceAsStream("/Resources/Items.json"));
        scanner.useDelimiter("\\A");

        if (!scanner.hasNext()) {
            // no items to load
            return;
        }

        String jsonText = scanner.next();

        JsonArray items = (JsonArray) Json.parse(jsonText);

        for (int i = 0; i < items.size(); ++i) {
            JsonObject currentItemData = (JsonObject) items.get(i);

            String itemType = currentItemData.get("type").asString();

            int id = currentItemData.get("id").asInt();
            String name = currentItemData.get("name").asString();
            int price = currentItemData.get("price").asInt();

            Item currentItem = null;
            boolean isWeapon = false;

            switch (itemType) {
                case "sword":
                    currentItem = new Sword(id, name, price);
                    isWeapon = true;
                    break;
                case "axe":
                    currentItem = new Axe(id, name, price);
                    isWeapon = true;
                    break;
                case "potion":
                    currentItem = new PotionItem(id, name, price,
                            currentItemData.get("potiondata")
                                    .asObject()
                                    .get("healthpointvalue")
                                    .asInt());
                    break;
            }

            if (isWeapon) {
                WeaponItem itemAsWeapon = (WeaponItem) currentItem;
                JsonObject weaponData = currentItemData.get("weapondata").asObject();
                itemAsWeapon.setRequiredStrength(weaponData.get("requiredstrength").asInt());
                itemAsWeapon.setRequiredDexterity(weaponData.get("requireddexterity").asInt());

                weaponItems.add(itemAsWeapon);
            }
            else {
                potionItems.add((PotionItem) currentItem);
            }
        }
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
