package read;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readArchivesByScanner {
    public static void main(String[] args) {
        
        File file  = new File("./docs/teste.txt");

        Scanner sc = null;

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                // sc = new Scanner(file);
                System.out.println(sc.nextLine());
            }

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}