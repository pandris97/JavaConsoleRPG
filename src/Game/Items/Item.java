
package Game.Items;


public abstract class Item {
    
    protected String name;
    protected Integer price;

    public Item() {
    }
    
    public Item(String name, Integer price) {
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
