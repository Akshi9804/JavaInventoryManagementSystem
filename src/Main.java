import java.util.*;

public class Main {
    public static void main(String[] args) {
        //creating an inventory for Dmart
        Inventory dmart = new Inventory();

        //creating items of different categories to add to Dmart's inventory
        Item item1 = new Item(1,"Hair Dryer","electronics",2);
        Item item2 = new Item(2,"Water Heater","electronics",3);
        Item item3 = new Item(3,"Cooker","electronics",2);
        Item item4 = new Item(4,"Organizer","furniture",5);
        Item item5 = new Item(5,"Wall Hanging","furniture",1);
        Item item6 = new Item(6,"Plastic Drawers","furniture",2);
        Item item7 = new Item(7,"Table","furniture",4);
        Item item8 = new Item(8,"Peanuts","grocery",4);
        Item item9 = new Item(9,"Salt","grocery",6);

        //adding items to Dmart's inventory
        dmart.addItem(item1);
        dmart.addItem(item2);
        dmart.addItem(item3);
        dmart.addItem(item4);
        dmart.addItem(item5);
        dmart.addItem(item6);
        dmart.addItem(item7);
        dmart.addItem(item8);
        dmart.addItem(item9);

        //trying to add an already existing item
        dmart.addItem(item7); //doesn't get added

        //updating the quantity of an existing item
        dmart.updateItemQuantity(4,3);

        //trying to update the quantity of an item that doesn't exist in the inventory
        dmart.updateItemQuantity(10,2); //prints the warning

        //updating the quantity to < 1
        dmart.updateItemQuantity(8, 0);

        //deleting an item
        dmart.deleteItem(9);

        //trying to delete an item that doesn't exist in the inventory
        dmart.deleteItem(9); //prints the warning

        //retrieving items by category
        System.out.println("--------------------------------------------------------------------");
        dmart.getItemsByCategory("furniture").stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");

        //retrieving top k items
        System.out.println("--------------------------------------------------------------------");
        dmart.getTopKItems(5).stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------");

        //creating an inventory for Dmart
        Inventory ratnadeep = new Inventory();

        //creating items of different categories to add to Ratnadeep's inventory
        Item item10 = new Item(10,"Extension Box","electronics",1);
        Item item11 = new Item(11,"Chair","furniture",8);
        Item item12 = new Item(3,"Cooker","electronics",4);
        Item item13 = new Item(12,"Cooking Oil","grocery",5);
        Item item14 = new Item(13,"Ear Pods","electronics",3);
        Item item15 = new Item(14,"Stool","furniture",1);

        //adding items to Ratnadeep's inventory
        ratnadeep.addItem(item10);
        ratnadeep.addItem(item11);
        ratnadeep.addItem(item12);
        ratnadeep.addItem(item13);
        ratnadeep.addItem(item14);
        ratnadeep.addItem(item15);


        //merging inventories of Dmart and Ratnadeep
        dmart.mergeInventory(ratnadeep);
        dmart.getAllItems();
    }
}
