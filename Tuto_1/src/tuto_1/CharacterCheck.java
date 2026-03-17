package tuto_1;
import java.io.File;
import java.util.Scanner;
public class CharacterCheck {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Tuto_1\\src\\tuto_1\\text1.txt");
        File file2=new File("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Tuto_1\\src\\tuto_1\\text2.txt");
        File file3=new File("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Tuto_1\\src\\tuto_1\\text3.txt");
        try{
            int count=0;
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                for(int i=0;i<line.length();i++){
                    char what=line.charAt(i);
                    if(Character.isLetterOrDigit(what)){
                        count++;
                        System.out.print(what);
                    }
                }
                System.out.println("");
            }
            sc.close();
        }
        catch(Exception e){
            
        }
    }
}
