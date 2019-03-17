package Game.Enemy;

import java.io.*;
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

    private void CreateEnemy(){
        Random rand = new Random();
        Name = "Goblin";
        Level = 1;
        Health = rand.nextInt(10);
        Damage = rand.nextInt(3)+1;
        XpGiven = Damage;
        GoldGiven = Damage*2;
    }

    public String getName(){
        return Name;
    }
}
