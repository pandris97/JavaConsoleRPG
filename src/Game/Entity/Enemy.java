package Game.Entity;

public abstract class Enemy {
    private String Name;
    private int Health;
    private int Level;
    private int Damage;
    private int XpGiven;
    private int GoldGiven;

    public Enemy(String Name, int Health, int Damage){

        this.Name = Name;
        this.Health = Health;
        this.Damage = Damage;
        this.XpGiven = (Damage+Health)*2;
        this.GoldGiven = XpGiven * 2;
    }

    public void receiveDamage(int amount){
        Health -= amount;
    }

    public boolean isAlive(){
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

    @Override
    public String toString(){
        return "Enemy name: " + getName() + ", Health: "+ getHealth()+ ", Damage: "+ getDamage();
    }
}


