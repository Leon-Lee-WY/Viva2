package Play;

public interface Interest {
    double computeInterest();
}

class SavingAccount implements Interest{
    double balance;
    
    SavingAccount(double bal){
        balance=bal;
    }
    
    @Override
    public double computeInterest(){
        return balance*0.005;
    }
}

class FixedAccount implements Interest{
    double balance;
    
    FixedAccount(double bal){
        balance=bal;
    }
    
    @Override
    public double computeInterest(){
        return balance*0.03;
    }
}

class Tester{
    public static void main(String[] args) {
        SavingAccount s1=new SavingAccount(10000);
        FixedAccount f1=new FixedAccount(10000);
        
        System.out.printf("Saving Account interest for 1 year: %.2f",s1.computeInterest());
        System.out.println("");
        System.out.printf("Fixed Account interest for 1 year: %.2f",f1.computeInterest());
        System.out.println("");
    }
}