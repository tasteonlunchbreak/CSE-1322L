package Lab9;
import java.util.Scanner;
import java.io.File;

public class Lab9 {
    public static String diff(File file1, File file2) {
        Scanner scanFile1 = null;
        Scanner scanFile2 = null;

        try {
            scanFile1 = new Scanner(file1);
            scanFile2 = new Scanner(file2);

            int numLines = 1;
            String result = "";

            while (scanFile1.hasNextLine() && scanFile2.hasNextLine()) {
                String line1 = scanFile1.nextLine();
                String line2 = scanFile2.nextLine();

                if (!line1.equals(line2)) {
                    result += "Line " + numLines + "\n";
                    result += "< " + line1 + "\n";
                    result += "> " + line2 + "\n";
                }
                numLines++;
            }
            if (scanFile1.hasNextLine() || scanFile2.hasNextLine()) {
                result += "Files have different number of lines\n";
            }
            if (result.equals("")) {
                return "Files are identical.\n";
            } 
            return result;

        } catch (Exception e) {
            if (!file1.exists()) {
                return e.getMessage() + "\n";
            } else {
                return e.getMessage() + "\n";
            }
        } finally {
            if (scanFile1 != null)
                scanFile1.close();
            if (scanFile2 != null)
                scanFile2.close();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("[Diff Detector]");
        System.out.print("Enter the name of file 1: ");
        String file1 = input.nextLine();

        System.out.print("Enter the name of file 2: ");
        String file2 = input.nextLine();
        System.out.println();

        File f1 = new File(file1);
        File f2 = new File(file2);

        String results = diff(f1,f2);
        System.out.println(results);

        System.out.println("Program complete");
       
        input.close();
    }

}  
