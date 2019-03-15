
package Game.Items;

public class Axe extends WeaponItem {

    public Axe(String name, Integer price) {
        super(name, price);
    }

    @Override
    public String toString() {
        String out =  "Axe name: " + name + ", price: " + price;
        String strength = (requiredStrength != null) ? ", required strength: " +  requiredStrength.toString() : "" ;   
        String dexterity = (requiredDexterity != null) ? ", required dexterity: " +  requiredDexterity.toString() : "";
        out += strength;
        out += dexterity;
        return out;
    }
    
}
