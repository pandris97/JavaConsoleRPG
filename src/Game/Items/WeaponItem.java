
package Game.Items;

public abstract class WeaponItem extends Item {

    protected Integer requiredDexterity;
    protected Integer requiredStrength;
    
    public WeaponItem(Integer id, String name, Integer price) {
        super(id, name, price);
    }

    public WeaponItem(Integer id, Integer requiredDexterity, Integer requiredStrength, String name, Integer price) {
        super(id, name, price);
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
