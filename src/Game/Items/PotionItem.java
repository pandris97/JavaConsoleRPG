
package Game.Items;


public final class PotionItem extends Item {
    
    private int healthPointValue;

    public PotionItem(String name, Integer price, int healthPointValue) {
        super(name, price);
        this.healthPointValue = healthPointValue;
    }

    public int getHealthPointValue() {
        return healthPointValue;
    }

    public void setHealthPointValue(int healthPointValue) {
        this.healthPointValue = healthPointValue;
    }

    @Override
    public String toString() {
        return "Potion name: " + name + ", price: " + price + ", restore hp: " + healthPointValue;
    }
   
}
