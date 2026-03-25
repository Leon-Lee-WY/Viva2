package Tuto3;
import java.util.Scanner;
public class CashRegister {
    private double machineCash;
    CashRegister(){
        machineCash=20;
    }
    double getMachineCash(){
        return machineCash;
    }
    void acceptCash(double x){
        machineCash+=x;
    }
}

class Dispenser{
    private int itemCount;
    private double cost;
    
    Dispenser(int itemCount,double cost){
        this.itemCount=itemCount;
        this.cost=cost;
    }
    int getItemCount(){
        return this.itemCount;
    }
    double getCost(){
        return this.cost;
    }
    void dec(){
        if(itemCount>0){
            itemCount--;
        }
    }
}

class CandyMachine {
    private CashRegister register;
    private Dispenser candy, chips, gum, cookies;
    private Scanner input = new Scanner(System.in);

    public CandyMachine() {
        register=new CashRegister();
        candy=new Dispenser(10, 1.50);
        chips=new Dispenser(10, 2.00);
        gum=new Dispenser(10, 0.75);
        cookies=new Dispenser(10, 2.50);
    }

    void start() {
        int choice;
        while (true) {
            System.out.println("\n--- SNACK MACHINE ---");
            System.out.println("1. Candy ($1.50) [" + candy.getItemCount() + " left]");
            System.out.println("2. Chips ($2.00) [" + chips.getItemCount() + " left]");
            System.out.println("3. Gum ($0.75) [" + gum.getItemCount() + " left]");
            System.out.println("4. Cookies ($2.50) [" + cookies.getItemCount() + " left]");
            System.out.println("5. Check Machine Balance");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            
            choice = input.nextInt();
            if (choice == 0) break;
            
            handleSelection(choice);
        }
    }

    private void handleSelection(int choice) {
        switch (choice) {
            case 1: processSale(candy); break;
            case 2: processSale(chips); break;
            case 3: processSale(gum); break;
            case 4: processSale(cookies); break;
            case 5: System.out.println("Balance: $" + register.getMachineCash()); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private void processSale(Dispenser d) {
        if (d.getItemCount() <= 0) {
            System.out.println("Sorry, out of stock!");
            return;
        }

        double price = d.getCost();
        System.out.println("Price: $" + price);
        System.out.print("Insert money: ");
        double money = input.nextDouble();

        if (money >= price) {
            d.dec();
            register.acceptCash(price);
            System.out.println("Dispensing item...");
            if (money > price) {
                System.out.println("Returning change: $" + (money - price));
            }
        } else {
            System.out.println("Not enough money! Returning your $" + money);
        }
    }

    public static void main(String[] args) {
        CandyMachine machine = new CandyMachine();
        machine.start();
    }
}