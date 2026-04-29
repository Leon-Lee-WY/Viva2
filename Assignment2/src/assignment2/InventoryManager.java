package assignment2;
import java.util.*;
import java.io.*;

public class InventoryManager {
    private ArrayList<Product> products=new ArrayList<>();

    public void loadFromFile(String filename) {
        try (Scanner sc=new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String[] data=sc.nextLine().split(",");
                products.add(new Product(Integer.parseInt(data[0].trim()), 
                             data[1].trim(), Double.parseDouble(data[2].trim()), 
                             Integer.parseInt(data[3].trim())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found. Starting fresh.");
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter pw=new PrintWriter(new FileWriter(filename))) {
            for (Product p:products) {
                pw.println(p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getStock());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    public void addProduct(Product p) {
        if (getProductById(p.getId())==null) {
            products.add(p);
        } else {
            System.out.println("Error: Duplicate ID.");
        }
    }
    
    public void removeProduct(int id) {
        Product p=searchById(id); 
        if (p!=null) {
            products.remove(p);
            System.out.println("Product " + id + " removed successfully.");
        } else {
            System.out.println("Error: Product ID " + id + " not found.");
        }
    }
    
    public Product searchById(int id) {
        for (Product p : products) {
            if (p.getId()==id) {
                return p; 
            }
        }
        return null; 
    }
    
    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> matchingProducts=new ArrayList<>(); 
        for (Product p:products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingProducts.add(p);
            }
        }
        return matchingProducts;
    }
    
    public void updateStock(int id, int newStock) {
        Product p=searchById(id);
        if (p!=null) {
            p.setStock(newStock); 
            System.out.println("Stock updated for ID " + id);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayAll() {
        System.out.println("ID    Name            Price      Stock");
        for (Product p:products) System.out.println(p);
    }
    
    public Product getProductById(int id) {
        for (Product p:products) {
            if (p.getId()==id) return p;
        }
        return null;
    }
    
    public boolean isAvailable(int id, int quantity) {
        Product p=getProductById(id);
        return (p!=null&&p.getStock()>=quantity);
    }
}

