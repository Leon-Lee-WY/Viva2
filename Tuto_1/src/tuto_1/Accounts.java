package tuto_1;
import java.util.Date;
public class Accounts {
    private int id=0;
    private double balance=0;
    private double annualInterestRate=0;
    private Date dateCreated;
    Accounts(){
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate=0.0;
        this.dateCreated=new Date();
    }
    Accounts(int id, double balance){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }
    int getID(){
        return this.id;
    }
    double getBalance(){
        return this.balance;
    }
    double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    void setID(int id){
        this.id=id;
    }
    void setBalance(double balance){
        this.balance=balance;
    }
    void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }
    Date getDateCreated(){
        return dateCreated;
    }
    double getMonthlyInterestRate(){
        return (this.annualInterestRate/100)/12;
    }
    double getMonthlyInterest(){
        return this.balance*getMonthlyInterestRate();
    }
    double withdraw(double amount){
        if(this.balance>=amount){
            this.balance=this.balance-amount;
        }
        else{
            System.out.println("Insufficient ammount.");
        }
        return this.balance;
    }
    double deposit(double amount){
        this.balance=this.balance+amount;
        return this.balance;
    }
}

class Tester{
    public static void main(String[] args) {
        Accounts acc1=new Accounts(1122,20000);
        acc1.setAnnualInterestRate(4.5);
        acc1.withdraw(2500);
        acc1.deposit(3000);
        System.out.println("Balance: RM"+acc1.getBalance());
        System.out.println("Interest: RM"+acc1.getMonthlyInterest());
        System.out.println("Date: "+acc1.getDateCreated());
    }
}
