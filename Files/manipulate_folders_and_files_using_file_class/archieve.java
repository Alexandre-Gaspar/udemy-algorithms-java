package manipulate_folders_and_files_using_file_class;

import java.util.Scanner;
import java.io.File;

public class archieve {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        try {
            File[] folders = path.listFiles(File::isDirectory);
            System.out.println("---------- List of folders ----------");
            for (File each : folders) {
                System.out.println(each);
            }

            System.out.println("---------- List of files ----------");
            File[] files = path.listFiles(File::isFile);
            for (File each : files) {
                System.out.println(each);
            }

            boolean success = new File(strPath + "/subdir").mkdir(); // Create a subdirectory on docs/
            System.out.printf("%nDirectory created successfully: %b%n", success);
        }
        catch (NullPointerException e) {
            System.out.println("This adress doesn't exists.");
        }
        finally {
            sc.close();
        }
    }
}
