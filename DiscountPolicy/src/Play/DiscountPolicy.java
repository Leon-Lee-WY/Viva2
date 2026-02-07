package Play;
public abstract class DiscountPolicy {
    abstract double computeDiscount(int count,double itemCost);
}
class BulkDiscount extends DiscountPolicy{
    int minimum;
    double discountrate;
    
    BulkDiscount(int minimum, double discountrate){
        this.minimum=minimum;
        this.discountrate=discountrate;
    }
    
    @Override
    public double computeDiscount(int count,double itemCost){
        if(count>this.minimum){
            return itemCost*count*this.discountrate;
        }
        return 0;
    }
}

class OtherDiscount extends DiscountPolicy{
    @Override
    public double computeDiscount(int count,double itemCost){
        if(count>=1 && count<=2){
            return 0;
        }
        else if(count>=3 && count<=5){
            return itemCost*count*0.1;
        }
        else if(count>=6 && count<=8){
            return itemCost*count*0.2;
        }
        else if(count>8){
            return itemCost*count*0.3;
        }
        return 0;
    }
}

class CombineDiscount extends DiscountPolicy{
    double max;
    BulkDiscount a;
    OtherDiscount b;
    CombineDiscount(BulkDiscount a,OtherDiscount b){
        this.a=a;
        this.b=b;
    }
    @Override
    public double computeDiscount(int count,double itemCost){
        if(this.a.computeDiscount(count, itemCost)>this.b.computeDiscount(count, itemCost)){
            return this.a.computeDiscount(count, itemCost);
        }
        else if(this.a.computeDiscount(count, itemCost)<this.b.computeDiscount(count, itemCost)){
            return this.b.computeDiscount(count, itemCost);
        }
        else{
            return this.a.computeDiscount(count, itemCost);
        }
    }
}

class Tester{
    public static void main(String[] args) {
        BulkDiscount b1=new BulkDiscount(2,0.4);
        OtherDiscount o1=new OtherDiscount();
        System.out.printf("BulkDiscount: %.2f",b1.computeDiscount(4, 33));
        System.out.println("");
        System.out.printf("OtherDiscount: %.2f",o1.computeDiscount(4,33));
        System.out.println("");
        CombineDiscount c1=new CombineDiscount(b1,o1);
        System.out.printf("Better discount: %.2f",c1.computeDiscount(4,33.0));
        System.out.println("");
    }
}
