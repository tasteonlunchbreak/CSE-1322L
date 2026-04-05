package Assignment6;
import java.io.*;
import java.util.*;

public class Assignment6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("[KSU Graduate Job Report]");

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();

        ArrayList<GraduateInfo> list = new ArrayList<>();
        int valid = 0;
        int invalid = 0;

        try {
            Scanner file = new Scanner(new File(fileName));
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter("errors.txt"));

            int lineNumber = 0;

            if (file.hasNextLine()) file.nextLine();

            while (file.hasNextLine()) {
                String line = file.nextLine();
                lineNumber++;

                try {
                    String[] parts = line.split(",");
                    if (parts.length < 16) {
                        throw new IncompleteEntryException("Missing field", lineNumber, line);
                    }
                    for (int i = 0; i < parts.length; i++) {
                        if (parts[i].isEmpty()) {
                            throw new IncompleteEntryException("Missing field '" + i + "'", lineNumber, line);
                        }
                    }
                    int salary = Integer.parseInt(parts[15]);
                    if (salary == 0) {
                        throw new IncompleteEntryException("Missing field 'estimated_salary'", lineNumber, line);
                    }
                    GraduateInfo g = new GraduateInfo(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5], parts[6], parts[7], parts[8], Integer.parseInt(parts[9]), parts[10], parts[11], parts[12], Integer.parseInt(parts[13]), parts[14], salary);

                    list.add(g);
                    valid++;
                } catch (IncompleteEntryException e) {
                    invalid++;
                    errorWriter.write(e.getMessage() + ", line " + e.getLineNumber());
                    errorWriter.write("\n" + e.getInfo());
                    errorWriter.write("\n----\n");
                }
            }
            errorWriter.close();
            file.close();

            BufferedWriter reportWriter = new BufferedWriter(new FileWriter("report.txt"));

            reportWriter.write("Higher Ed Different Uni: " + Queries.higherEduAtDiffUni(list) + "\n");

            int[] edu = Queries.highestEducationLvl(list);
            reportWriter.write("Education Levels:\n");

            for (int i = 0; i < edu.length; i++) {
                reportWriter.write(edu[i] + "\n");
            }
            int[] years = Queries.lastYearAtKSU(list);
            reportWriter.write("Years at KSU:\n");
            
            for (int i = 0; i < years.length; i++) {
                reportWriter.write(years[i] + "\n");
            }
            ArrayList<String> top5 = Queries.topFiveIndustries(list);
            reportWriter.write("Top Industries:\n");
            for (String s : top5) {
                reportWriter.write(s + "\n");
            }
            reportWriter.close();

            System.out.println("There was a total of " + valid + " valid entries and " + invalid + " invalid entries.");
            System.out.println("Report written to 'report.txt'. Errors written to 'errors.txt'");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the specified file.");
        } catch (IOException e ) {
            System.out.println("File writing error.");
        }
        System.out.println("Program complete.");
        input.close();
    } 
    
}
