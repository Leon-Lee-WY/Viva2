package tuto_1;
public class Telephone {
    String areaCode;
    String number;
    static int numberOfTelephoneObjects;
    Telephone(String areaCode,String number){
        this.areaCode=areaCode;
        this.number=number;
    }
    String getAreaCode(){
        return this.areaCode;
    }
    String getNumber(){
        return this.number;
    }
    void setAreaCode(String areaCode){
        this.areaCode=areaCode;
    }
    void setNumber(String number){
        this.number=number;
    }
    String makeFullNumber(){
        return this.areaCode+"-"+this.number;
    }
}

class Tester{
    public static void main(String[] args) {
        Telephone[]telephone=new Telephone[5];
        telephone[0]=new Telephone("03","9522723");
        telephone[1]=new Telephone("03","6666663");
        telephone[2]=new Telephone("06","9999966");
        telephone[3]=new Telephone("07","9273922");
        telephone[4]=new Telephone("01","2345678");
        for(int x=0;x<=4;x++){
            System.out.println(telephone[x].makeFullNumber());
        }
    }
}

/*2. (1) Performs Person's tasks
     (2) Invoke Employee's overloaded constructor
     (3) Performs Employee's tasks 
     (4) Performs Faculty's tasks*

Explanation: Faculty Object is created and the class will call the extended class 
which is employee before printing the lines in the Faculty class,the Employee class will call the super class Person and print the lines
in Person class before printing the this line and the lines in the employee constructor/

/*3.   a.AB

Explanation: The b object is called first so the toString method will override the toString method from class B to print out A first.
Then the b object is called and the toString method will override the toString method in class A previously to B again
*/