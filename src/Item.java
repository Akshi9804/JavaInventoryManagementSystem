

public class Item implements Comparable<Item>{
    private final int id;
    private final String name;
    private final String category;
    private int quantity;

    public Item(int id, String name, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Item[ ID : %d \t Name : %s \t Category : %s \t Quantity : %d ]", id, name, category, quantity);
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(o.getQuantity(),quantity);
    }
}
