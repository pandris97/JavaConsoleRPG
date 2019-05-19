package Game.Player;

import Util.JSON.Json;
import Util.JSON.JsonObject;

public class PlayerStats {

    private int MaxHealth;
    private int CurrentHealth;
    private int Strength;
    private int Dexterity;

    // default values
    public PlayerStats() {
        MaxHealth = 100;
        CurrentHealth = MaxHealth;
        Strength = 1;
        Dexterity = 0;
    }

    public static PlayerStats loadFromJSON(JsonObject json) {
        PlayerStats stats = new PlayerStats();

        if (json.contains("maxhealth"))
            stats.MaxHealth = json.get("maxhealth").asInt();

        if (json.contains("currenthealth"))
            stats.CurrentHealth = json.get("currenthealth").asInt();

        if (json.contains("strength"))
            stats.Strength = json.get("strength").asInt();

        if (json.contains("dexterity"))
            stats.Dexterity = json.get("dexterity").asInt();

        return stats;
    }

    public void saveToJSON(JsonObject json) {
        JsonObject characterStats = Json.object();
        json.add("stats", characterStats);
        characterStats.add("maxhealth", MaxHealth);
        characterStats.add("currenthealth", CurrentHealth);
        characterStats.add("strength", Strength);
        characterStats.add("dexterity", Dexterity);
    }

    public int getMaxHealth() {
        return MaxHealth;
    }

    public void setMaxHealth(int value) {
        if (value < 1)
            value = 1;

        MaxHealth = value;
    }

    public int getCurrentHealth() {
        return CurrentHealth;
    }

    public void setCurrentHealth(int value) {
        if (value > MaxHealth)
            value = MaxHealth;

        CurrentHealth = value;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int value) {
        if (value < 0)
            value = 0;

        Strength = value;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int value) {
        if (value < 0)
            value = 0;

        Dexterity = value;
    }
}
