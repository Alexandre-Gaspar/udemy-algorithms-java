package write;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class writeArchievesByFileAndBufferedWriter {

    public static void main(String[] args) {
        
        String[] daysOfTheWeek = new String[]
        {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        String path = "docs/teste2.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            // daysOfTheWeek[daysOfTheWeek.length - 1] = "Saturday";
            
            for (String day : daysOfTheWeek) {
                bw.write(day);
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}