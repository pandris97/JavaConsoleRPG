package Game.Adventure;

import java.util.Random;

public class Enemy {
    private String Name;
    private int Health;
    private int Level;
    private int Damage;
    private int XpGiven;
    private int GoldGiven;
    public String Type;

    public Enemy(){
        CreateEnemy();
    }

    private void CreateEnemy() {
        Random rand = new Random();
        Name = "Goblin";
        Level = 1;
        Health = 10;
        Damage = rand.nextInt(3) + 1;
        XpGiven = Damage;
        GoldGiven = Damage * 2;
    }

    public void receiveDamage(int amount){
        Health -= amount;
    }

    boolean isAlive(){
        return Health > 0;
    }

    public String getName(){
        return Name;
    }

    public int getDamage(){
        return Damage;
    }

    public int getXpGiven(){
        return XpGiven;
    }

    public int getHealth(){
        return Health;
    }

    public int getGoldGiven(){
        return GoldGiven;
    }
}
