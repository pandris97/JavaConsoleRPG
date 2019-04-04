package Game.Player;

import Game.Items.Item;
import Game.Items.WeaponItem;
import Game.Shop.Shop;
import Util.JSON.Json;
import Util.JSON.JsonArray;
import Util.JSON.JsonObject;
import Util.JSON.JsonValue;

public class PlayerItems {

    // can be null
    WeaponItem Weapon;

    private static final int MaxInventorySize = 10;
    Item[] Inventory;

    PlayerItems() {
        Inventory = new Item[MaxInventorySize];
    }

    public static PlayerItems loadFromJSON(JsonObject json) {
        PlayerItems items = new PlayerItems();

        if (json.contains("weapon")) {
            int weaponID = json.get("weapon").asInt();

            WeaponItem weaponItem = (WeaponItem) Shop.getItemById(weaponID);

            items.Weapon = weaponItem;
        }

        JsonArray inventory = json.get("inventory").asArray();

        items.Inventory = new Item[MaxInventorySize];

        for (int i = 0; i < MaxInventorySize; ++i) {
            JsonValue currentValue = inventory.get(i);

            if (currentValue.isNull()) {
                items.Inventory[i] = null;
                continue;
            }

            int currentItemID = currentValue.asInt();
            Item currentItem = Shop.getItemById(currentItemID);
            items.Inventory[i] = currentItem;
        }

        return items;
    }

    public void saveToJSON(JsonObject json) {
        JsonObject characterItems = Json.object();
        json.add("items", characterItems);

        if (Weapon == null)
            characterItems.add("weapon", Json.NULL);
        else
            characterItems.add("weapon", Weapon.getID());

        JsonArray inventory = new JsonArray();
        characterItems.add("inventory", inventory);

        for (int i = 0; i < MaxInventorySize; ++i)
        {
            Item currentItem = Inventory[i];
            if (currentItem != null)
                inventory.add(currentItem.getID());
            else
                inventory.add(Json.NULL);
        }
    }
}
