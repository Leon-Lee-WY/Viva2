package tuto_1;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class letter {
    public static void main(String[] args) {
        try {
            Path filePath = Paths.get("C:\\Users\\lwylw\\OneDrive\\Documents\\NetBeansProjects\\learn-repo\\Tuto_1\\src\\tuto_1\\Yong_25005996.txt");
            
            List<String> allLines = Files.readAllLines(filePath);
            
            for (String line : allLines) {
                System.out.println(line);
            }
            
        } catch (Exception e) {
            System.out.println("Something went wrong reading the file.");
        }
    }
}
