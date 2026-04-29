package assignment2;
import java.util.Scanner;
import java.util.ArrayList;

public class GroceryStoreSystem {
    private static InventoryManager invManager = new InventoryManager();
    private static CartList cart = new CartList();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        invManager.loadFromFile("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Assignment2\\src\\assignment2\\inventory.txt");
        boolean running = true;

        while (running) {
            System.out.println("\n========= GROCERY STORE SYSTEM =========");
            System.out.println("1. Display Inventory      6. Add to Cart");
            System.out.println("2. Search Product         7. View Cart");
            System.out.println("3. Add New Product        8. Remove from Cart");
            System.out.println("4. Remove Product (Inv)   9. Update Cart Qty");
            System.out.println("5. Update Stock (Inv)     10. Undo Last Add");
            System.out.println("----------------------------------------");
            System.out.println("11. Clear Cart            12. Checkout");
            System.out.println("13. Save and Exit");
            System.out.println("========================================");
            int choice = getIntInput("Select an option: ");

            switch (choice) {
                // Task 1: Inventory Management
                case 1: invManager.displayAll(); break;
                case 2: searchProduct(); break;
                case 3: addNewProduct(); break;
                case 4: removeProductFromInventory(); break;
                case 5: updateInventoryStock(); break;

                // Task 2: Shopping Cart
                case 6: addToCart(); break;
                case 7: cart.displayCart(); break;
                case 8: removeFromCart(); break;
                case 9: updateCartQty(); break;
                case 10: cart.undo(); break;
                case 11: cart.clear(); System.out.println("Cart cleared. Stock not automatically restored (manual logic required if cancelled)."); break;

                // Task 3: Checkout and Exit
                case 12: checkout(); break;
                case 13: 
                    invManager.saveToFile("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Assignment2\\src\\assignment2\\inventory.txt");
                    System.out.println("Inventory saved. Goodbye!");
                    running = false;
                    break;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // --- TASK 1 HELPER METHODS ---
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        int val = sc.nextInt();
        sc.nextLine();
        return val;
    }
    
    private static void searchProduct() {
        System.out.println("Enter 1 to search by ID, 2 to search by product name");
        int type = getIntInput("Choice: ");
        if (type == 1) {
            int id = getIntInput("Enter ID: ");
            Product p = invManager.searchById(id);
            System.out.println(p != null ? p : "Not found.");
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            ArrayList<Product> results = invManager.searchByName(name);
            if (results.isEmpty()) System.out.println("No matches.");
            else results.forEach(System.out::println);
        }
    }

    private static void addNewProduct() {
        int id = getIntInput("Enter New ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        double price = getDoubleInput("Enter Price: ");
        int stock = getIntInput("Enter Stock: ");
        invManager.addProduct(new Product(id, name, price, stock));
    }

    private static void removeProductFromInventory() {
        int id = getIntInput("Enter ID to remove from inventory: ");
        invManager.removeProduct(id);
    }

    private static void updateInventoryStock() {
        int id = getIntInput("Enter ID: ");
        int qty = getIntInput("Enter New Stock Level: ");
        invManager.updateStock(id, qty);
    }

    // --- TASK 2 HELPER METHODS ---

    private static void addToCart() {
        int id = getIntInput("Enter Product ID: ");
        int qty = getIntInput("Enter Quantity: ");

        if (invManager.isAvailable(id, qty)) {
            Product p = invManager.getProductById(id);
            p.setStock(p.getStock() - qty);
            cart.addItem(p, qty);
            System.out.println("Added to cart.");
        } else {
            System.out.println("Insufficient stock or product doesn't exist!");
        }
    }

    private static void removeFromCart() {
        int id = getIntInput("Enter Product ID to remove from cart: ");
        CartNode removed = cart.removeItem(id);
        if (removed != null) {
            // Restore stock
            removed.product.setStock(removed.product.getStock() + removed.quantity);
            System.out.println("Item removed and stock restored.");
        } else {
            System.out.println("Item not in cart.");
        }
    }

    private static void updateCartQty() {
        int id = getIntInput("Enter Product ID: ");
        int newQty = getIntInput("Enter New Quantity: ");
        cart.updateQuantity(id, newQty);
    }

    // --- TASK 3 HELPER METHODS ---

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("\n******* FINAL BILL *******");
        cart.displayCart();
        System.out.println("**************************");
        System.out.println("Payment Successful!");
        
        cart.clear(); // Clear cart and implicitly the undo stack
        System.out.print("Would you like to save changes to file now? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            invManager.saveToFile("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Assignment2\\src\\assignment2\\inventory.txt");
        }
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        double val = sc.nextDouble();
        sc.nextLine(); 
        return val;
    }
}