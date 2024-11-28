import java.util.*;

public class Inventory {
    private final Map<String, TreeSet<Item>> categoryMap;
    private final Map<Integer, Item> idMap;

    public Inventory() {
        System.out.println("An inventory is created");
        categoryMap = new HashMap<>();
        idMap = new HashMap<>();
        System.out.println("--------------------------------------------------------------------");
    }

    public void getAllItems(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Items in the inventory are:");
        if(idMap.isEmpty()) {
            System.out.println("No items exist in the inventory");
        }
        else{
            for (Item item : idMap.values()) {
                System.out.println(item);
            }
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void addItem(Item item) {
        if (idMap.containsKey(item.getId())) {
            System.out.println("Item with ID " + item.getId() + " already exists. Use updateItemQuantity to modify.");
            return;
        }
        System.out.println("Item is successfully added into the inventory");
        idMap.put(item.getId(), item);
        categoryMap.computeIfAbsent(item.getCategory(), k -> new TreeSet<>()).add(item);
    }

    public void updateItemQuantity(Integer id, int quantity) {
        if (!idMap.containsKey(id)) {
            System.out.println("Item with ID " + id + " does not exist.");
            return;
        }
        Item item = idMap.get(id);
        System.out.println("Quantity of item with ID " + item.getId() + " is successfully updated from " + item.getQuantity() + " to " + quantity);
        categoryMap.get(item.getCategory()).remove(item); // Remove outdated item
        item.setQuantity(quantity);
        categoryMap.get(item.getCategory()).add(item); // Add updated item
        checkRestocking();
    }

    public void deleteItem(Integer id) {
        if (!idMap.containsKey(id)) {
            System.out.println("Item with ID " + id + " does not exist.");
            return;
        }
        Item item = idMap.remove(id);
        System.out.println("Item with ID " + item.getId() + " and name " + item.getName() + " is successfully removed");
        categoryMap.get(item.getCategory()).remove(item);
        if (categoryMap.get(item.getCategory()).isEmpty()) {
            categoryMap.remove(item.getCategory());
        }
    }

    public List<Item> getItemsByCategory(String category) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("No items found in category: " + category);
            return Collections.emptyList();
        }
        System.out.println("The items in " +  category + " are:");
        return new ArrayList<>(categoryMap.get(category));
    }

    public List<Item> getTopKItems(int k) {
        System.out.println("The top k items are: ");
        PriorityQueue<Item> maxHeap = new PriorityQueue<>();
        for (Item item : idMap.values()) {
            maxHeap.add(item);
        }
        List<Item> topK = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            topK.add(maxHeap.poll());
        }
        return topK;
    }

    public void mergeInventory(Inventory other) {
        System.out.println("Merged inventories:");
        for (Item item : other.idMap.values()) {
            if (idMap.containsKey(item.getId())) {
                Item existing = idMap.get(item.getId());
                if (item.getQuantity() > existing.getQuantity()) {
                    updateItemQuantity(existing.getId(), item.getQuantity());
                }
            } else {
                addItem(item);
            }
        }
    }

    public void checkRestocking() {
        for (Item item : idMap.values()) {
            if (item.getQuantity() < 1) {
                System.out.println("----------Restock Alert: " + item+" ----------");
            }
        }
    }

}
