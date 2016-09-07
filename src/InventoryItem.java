/**
 * Created by halleyfroeb on 9/6/16.
 */
public class InventoryItem {

    protected String name;
    protected int quantity;
    protected String category;

    public InventoryItem(String text, int quantity, String category) {
        this.name = text;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void getName(String text) {
        this.name = text;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
