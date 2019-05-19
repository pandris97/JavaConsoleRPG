package Game.Player;

import Game.Items.Item;
import Game.Items.ItemType;
import Game.Items.WeaponItem;
import Util.JSON.Json;
import Util.JSON.JsonObject;
import Util.JSON.ParseException;

import java.io.*;

import java.util.Scanner;

public class Player {

    private static Player CurrentCharacter = null;

    private final String Name;
    private int Level;
    private int Experience;
    private int Gold;
    private static File deleteFile;

    private PlayerStats Stats;
    private PlayerItems Items;

    public Player(String name) {
        Name = name;
        Level = 1;
        Experience = 0;
        Gold = 0;

        Stats = new PlayerStats();
        Items = new PlayerItems();
    }

    public static Player loadFromFile(String playerName) {
        deleteFile = new File("save/" + playerName + ".save");
        File saveFile = new File("save/" + playerName + ".save");

        if (!saveFile.exists())
            return null;

        try (FileInputStream reader = new FileInputStream(saveFile)) {
            byte[] bytes = new byte[(int)saveFile.length()];
            reader.read(bytes);
            JsonObject characterData = Json.parse(new String(bytes, "UTF-8")).asObject();

            Player character = new Player(characterData.get("name").asString());

            if (characterData.contains("level"))
                character.Level = characterData.get("level").asInt();
            else
                character.Level = 1;

            if (characterData.contains("experience"))
                character.Experience = characterData.get("experience").asInt();
            else
                character.Experience = 0;

            if (characterData.contains("gold"))
                character.Gold = characterData.get("gold").asInt();
            else
                character.Gold = 0;

            if (characterData.contains("stats"))
                character.Stats = PlayerStats.loadFromJSON(characterData.get("stats").asObject());

            if (characterData.contains("items"))
                character.Items = PlayerItems.loadFromJSON(characterData.get("items").asObject());

            CurrentCharacter = character;
            return character;
        }
        catch (IOException | ParseException | NullPointerException ex) {
            return null;
        }
    }

    // returns a string if there was an error during saving the file
    // if it was successful, null is returned
    // isNew - true if the character was just created, so we don't overwrite an existing file
    public String saveToFile(boolean isNew) {

        File saveFileDirectory = new File("save");
        if (!saveFileDirectory.isDirectory()) {
            if (!saveFileDirectory.mkdirs())
                return "cannot create folder for save files";
        }

        File saveFile = new File("save/" + Name + ".save");
        deleteFile = new File("save/" + Name + ".save");

        if (saveFile.exists()) {
            if (isNew) {
                return "this character already exists";
            }
        } else {
            try {
                saveFile.createNewFile();
            } catch (IOException ex) {
                return "cannot save file (maybe the name contains invalid characters, or no permission to create the file)";
            }
        }

        JsonObject characterData = Json.object();
        characterData.add("name", Name);
        characterData.add("level", Level);
        characterData.add("experience", Experience);
        characterData.add("gold", Gold);

        Stats.saveToJSON(characterData);
        Items.saveToJSON(characterData);

        try (PrintWriter writer = new PrintWriter(saveFile)) {
            writer.print(characterData.toString());
        }
        catch (IOException ex) {
            return "cannot write file";
        }

        return null;
    }

    public static Player getCurrentCharacter() {
        return CurrentCharacter;
    }

    public static void setCurrentCharacter(Player character) {
        CurrentCharacter = character;
    }

    public String getName() {
        return Name;
    }

    public int getMoney() {
        return Gold;
    }

    public void addMoney(int amount) {
        if (amount < 0)
            return;

        Gold += amount;
    }

    public boolean hasEnoughMoney(int amount) {
        return Gold >= amount;
    }

    public boolean spendMoney(int amount) {
        if (amount < 0)
            return false;

        if (!hasEnoughMoney(amount))
            return false;

        Gold -= amount;
        return true;
    }

    public int getLevel() {
        return Level;
    }

    public int getExperience() {
        return Experience;
    }

    public void addExperience(int xp) {
        if (xp < 0)
            return;

        Experience += xp;

        levelUpIfNeeded();
    }

    // Experience for next level is currently 10 * level^2
    public int getExperienceForNextLevel() {
        return 10 * Level * Level;
    }

    private void levelUpIfNeeded() {
        int requiredXP;

        while (Experience >= (requiredXP = getExperienceForNextLevel())) {
            Experience -= requiredXP;
            ++Level;
            // maybe add some talent points later
        }
    }

    private void die() {
        deleteFile.delete();
        
        
        System.out.println("Your character " + Name + " was slain.");
        System.out.println("Try to be more cautious next time");
        System.out.println("Game Over...");
        System.out.print("press any key to exit");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        System.exit(0);
    }

    public void receiveDamage(int dmg) {
        if (dmg < 0)
            return;

        Stats.setCurrentHealth(Stats.getCurrentHealth() - dmg);

        if (Stats.getCurrentHealth() <= 0)
            die();
    }

    public void restoreHealth(int hp) {
        if (hp < 0)
            return;

        Stats.setCurrentHealth(Stats.getCurrentHealth() + hp);
    }

    public PlayerStats getStats() {
        return Stats;
    }

    public PlayerItems getItemData() { 
        return Items; 
    }

    // returns true if the purchase was successful, else returns false
    public boolean buyItem(Item newItem) {
        if (!hasEnoughMoney(newItem.getPrice()))
            return false;
        if (newItem.getType() == ItemType.AXE || newItem.getType() == ItemType.SWORD) {
            WeaponItem itemAsWeapon = (WeaponItem) newItem;
            if (itemAsWeapon.getRequiredDexterity() > getStats().getDexterity() ||
                itemAsWeapon.getRequiredStrength() > getStats().getStrength())
                return false;
        }

        if (!Items.storeNewItem(newItem))
            return false;

        spendMoney(newItem.getPrice());
        return true;
    }

    public void sellItem(Item item) {
        for (int i = 0; i < PlayerItems.MaxInventorySize; ++i) {
            Item currentItem = Items.getInventoryItem(i);

            if (currentItem == item) {
                Items.removeInventoryItem(i);
                addMoney(item.getPrice());
                return;
            }
        }
    }
}
