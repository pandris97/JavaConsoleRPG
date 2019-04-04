
package Game.Items;


public abstract class Item {
    
    protected String name;
    protected Integer price;
    protected final Integer ID;
    
    public Item(Integer id, String name, Integer price) {
        this.ID = id;
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
    
    
    @Override
    public abstract String toString();
    
}
