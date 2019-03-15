
package Game.Items;

public abstract class WeaponItem extends Item {

    protected Integer requiredDexterity;
    protected Integer requiredStrength;
    
    public WeaponItem(String name, Integer price) {
        super(name, price);
    }

    public WeaponItem(Integer requiredDexterity, Integer requiredStrength, String name, Integer price) {
        super(name, price);
        this.requiredDexterity = requiredDexterity;
        this.requiredStrength = requiredStrength;
    }    
    
    public Integer getRequiredDexterity() {
        return requiredDexterity;
    }

    public void setRequiredDexterity(Integer requiredDexterity) {
        this.requiredDexterity = requiredDexterity;
    }

    public Integer getRequiredStrength() {
        return requiredStrength;
    }

    public void setRequiredStrength(Integer requiredStrength) {
        this.requiredStrength = requiredStrength;
    }

    @Override
    public abstract String toString();
    
}
