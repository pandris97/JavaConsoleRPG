
package Game.Items;


public abstract class Item {
    
    protected String name;
    protected Integer price;
    protected final Integer ID;
    protected final ItemType type;
    
    public Item(Integer id, ItemType type, String name, Integer price) {
        this.ID = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ItemType getType() { return type; }

    public Integer getID() { return ID; }
    
    @Override
    public abstract String toString();
    
}
