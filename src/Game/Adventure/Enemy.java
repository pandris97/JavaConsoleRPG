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

    Enemy(){
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

    @Override
    public String toString(){
        return "Ellenfél neve: " + getName() + ", Életereje: "+ getHealth()+ ", Támadóereje: "+ getDamage();
    }

    void receiveDamage(int amount){
        Health -= amount;
    }

    boolean isAlive(){
        return Health > 0;
    }

    String getName(){
        return Name;
    }

    int getDamage(){
        return Damage;
    }

    int getXpGiven(){
        return XpGiven;
    }

    int getHealth(){
        return Health;
    }

    int getGoldGiven(){
        return GoldGiven;
    }
}
