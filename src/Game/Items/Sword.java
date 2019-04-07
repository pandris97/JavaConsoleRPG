
package Game.Items;

public class Sword extends WeaponItem {

    public Sword(Integer id, String name, Integer price) {
        super(id, ItemType.SWORD, name, price);
    }

    @Override
    public String toString() {
        String out = ID +  " Sword name: " + name + ", price: " + price;
        String strength = (requiredStrength != null) ? ", required strength: " +  requiredStrength.toString() : "" ;   
        String dexterity = (requiredDexterity != null) ? ", required dexterity: " +  requiredDexterity.toString() : "";
        out += strength;
        out += dexterity;
        return out;
    }
    
}
