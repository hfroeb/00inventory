import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by halleyfroeb on 9/6/16.
 */
public class Inventory {
    public static void main(String[] args) {

        ArrayList<InventoryItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {

            showList(items);

            System.out.println("Options");

            System.out.println("1. Create a new item");
            System.out.println("2. Remove an item");
            System.out.println("3. Update the quantity of an item");

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    try {
                        createItem(items, scanner);
                    } catch (Exception e) {
                        System.out.println("Invalid Category!");
                    }
                    InventoryItem item;
                    break;
               case "2":
                   deleteItem(items, scanner);
                   break;
                case "3":
                    updateQuantity(items, scanner);
                    break;
                default:
                    System.out.println("Invalid option");
            }

        }

    }
    private static void createItem(ArrayList<InventoryItem> items, Scanner scanner) throws Exception{
        System.out.println("Enter new item name");
        String name = scanner.nextLine();
        System.out.println("Enter the amount of " + name);
        Integer quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter category of item [food/ clothing/ drinks/ jewelry/ electronics");
        String category = scanner.nextLine().toLowerCase();

        if (category.equals("food")){
            Food food = new Food(name, quantity);
            items.add(food);
        }
        else if (category.equals("clothing")){
            Clothing clothing = new Clothing(name, quantity);
            items.add(clothing);
        }
        else if (category.equals("drinks")){
            Drinks drinks = new Drinks(name, quantity);
            items.add(drinks);
        }
        else if (category.equals("jewelry")){
            Jewelry jewelry = new Jewelry(name, quantity);
            items.add(jewelry);
        }
        else if (category.equals("electronics")){
            Electronics electronics = new Electronics(name, quantity);
            items.add(electronics);
        }
        else {
                throw new Exception("Invalid Category!");
        }

    }

    private static void updateQuantity(ArrayList<InventoryItem> items, Scanner scanner) {
        InventoryItem item;
        System.out.println("Enter the item's number that you want to update");
        int itemIndex = Integer.parseInt(scanner.nextLine());
        item = items.get(itemIndex - 1);
        System.out.println("Enter the quantity of " + item.getName() + " in your inventory");
        Integer newQuantity = Integer.parseInt(scanner.nextLine());
        item.setQuantity(newQuantity);
        items.set(itemIndex-1, item);
        System.out.println("You have " + item.getQuantity() + " " + item.getName());
    }

    private static void deleteItem(ArrayList<InventoryItem> items, Scanner scanner) {
        InventoryItem item;
        System.out.println("Enter the item's number that you want to remove");
        int itemNum = Integer.parseInt(scanner.nextLine());
        item = items.get(itemNum - 1);
        items.remove(item);
    }


    private static void showList(List<InventoryItem> items) {
        int i = 1;
        for (InventoryItem item : items) {
            System.out.printf("%s . [%s] %s, %s \n", i, item.getQuantity(), item.getName(), item.getCategory());
            i++;
        }
    }
}