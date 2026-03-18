package tuto_1;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
public class Accounts1 {
    private String name;
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    private Date dateCreated;
    private ArrayList<Transaction> transaction;
    Accounts1(){
        this.transaction=new ArrayList();
        this.dateCreated=new Date();
    }
    Accounts1(String name,int id, double balance){
        this.name=name;
        this.id=id;
        this.balance=balance;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
        this.transaction=new ArrayList<>();
    }
    int getId(){ 
        return this.id; 
    }
    void setId(int id){ 
        this.id=id; 
    }

    double getBalance(){ 
        return this.balance; 
    }
    void setBalance(double balance) {
       this.balance=balance; 
    }

    double getAnnualInterestRate(){
        return this.annualInterestRate; 
    }
    void setAnnualInterestRate(double annualInterestRate){ 
        this.annualInterestRate = annualInterestRate; 
    }

    String getName(){
        return this.name; 
    }
    void setName(String name){ 
        this.name=name;}

    Date getDateCreated(){ 
        return this.dateCreated; 
    }
    
    ArrayList<Transaction> getTransaction(){ 
        return this.transaction; 
    }

    double getMonthlyInterestRate() {
        return (this.annualInterestRate/100)/ 12;
    }

    double getMonthlyInterest(){
        return this.balance* getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance=this.balance- amount;
            transaction.add(new Transaction('W', amount, balance, "Withdrawal"));
        } 
        else{
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance=this.balance+amount;
            transaction.add(new Transaction('D', amount, balance, "Deposit"));
        }
    }
}

class Transaction{
    private Date dateCreated;
    private char type;
    private double amount;
    private double balance;
    private String description;
    public Transaction(char type,double amount,double balance,String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.dateCreated= new Date();
    }
    public Date getDateCreated(){ 
        return this.dateCreated; 
    }
    public char getType(){ 
        return this.type; 
    }
    public double getAmount(){
        return this.amount;
    }
    public double getBalance(){
        return this.balance; 
    }
    public String getDescription(){
        return this.description; 
    }
}

class Tester{
    public static void main(String[] args) {
        Accounts1 acc1=new Accounts1("George",1122,1000);
        acc1.setAnnualInterestRate(1.5);
        acc1.deposit(30);
        acc1.deposit(40);
        acc1.deposit(50);
        acc1.withdraw(5);
        acc1.withdraw(4);
        acc1.withdraw(2);
        
        System.out.println("Name: "+acc1.getName());
        System.out.println("Interest: RM"+acc1.getMonthlyInterest());
        System.out.println("Balance: RM"+acc1.getBalance());
        for (Transaction t:acc1.getTransaction()) {
            System.out.printf("%-30s %-10c $%-9.2f $%-9.2f\n", 
                t.getDateCreated().toString(), 
                t.getType(), 
                t.getAmount(), 
                t.getBalance());
        }
    }
}
