package Game.Player;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Player implements Serializable {

    private final String Name;
    private int Level;
    private int Experience;
    private int Gold;

    public Player(String name) {
        Name = name;
        Level = 1;
        Experience = 0;
        Gold = 0;
    }

    public static Player loadFromFile(String playerName) {
        File saveFile = new File(playerName + ".save");

        if (!saveFile.exists())
            return null;

        try (
                FileInputStream stream = new FileInputStream(saveFile);
                ObjectInputStream inputStream = new ObjectInputStream(stream)) {
            return (Player) inputStream.readObject();
        }
        catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public boolean saveToFile() {
        File saveFile = new File(Name + ".save");

        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException ex) {
                return false;
            }
        }

        try (
        FileOutputStream stream = new FileOutputStream(saveFile);
        ObjectOutputStream outputStream = new ObjectOutputStream(stream)) {
            outputStream.writeObject(this);
            outputStream.flush();
        }
        catch (IOException ex) {
            return  false;
        }

        return true;
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

    public boolean reduceMoney(int amount) {
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
}