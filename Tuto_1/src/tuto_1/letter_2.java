package tuto_1;
import java.io.FileWriter;
import java.io.IOException;
public class letter_2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Tuto_1\\src\\tuto_1\\Yong_25005996.txt",true);
        fw.write("Friday, 6 June 2026\n");
        fw.write("What's up Wuey Yong from the past this is Wuey Yong from the future.Honestly, DS ain't that hard.\n");
        fw.write("So far every subject I still got it. Not to brag and I am happy to say, that i think imma ace this sem again man.\n");
        fw.write("DS has taught me something bro, like stack, queue, linkedlist blah blah you will get it easy bro.\n");
        fw.write("Like i said don't worry, man. You'll ace this subject eventually, grind more leetcode, and consult ur friends bro.\n");
        fw.write("I did well in nothing actually i just go with the flow and everything works out fortunately.\n");
        fw.write("However, there is one thing. Don't burn the midnight oil too much bro, stay healthy. This course will silently torture u bro.\n");
        fw.close();
    }
}
