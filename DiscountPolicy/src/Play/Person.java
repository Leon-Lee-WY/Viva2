package Play;
import java.util.Arrays;
public class Person implements Comparable<Person>{
    String name;
    
    Person(String name){
        this.name=name;
    }
    
    String getname(){
        return this.name;
    }
    
    void printname(){
        System.out.println("Name: "+this.name);
    }
    
    @Override
    public int compareTo(Person other){
        return this.name.compareTo(other.name);
    }
    
    public String toString(){
        return name;
    }
}

class Tester{
    public static void main(String[] args) {
        Person p1=new Person("Lee");
        Person p2=new Person("Joanne");
        p1.printname();
        p2.printname();
        
        Person[]one={new Person("John"),
                     new Person("Lily"),
                     new Person("Barry")};
        Arrays.sort(one);
        for(Person x:one){
            System.out.println(x);
        }  
    }
}
