import java.util.Scanner;

public class Lab8 {
    public static int differenceInSeconds(String startTime, String endTime) throws InvalidTimeException {
        String[] t1 = startTime.split(":");
        String[] t2 = endTime.split(":");

        if (t1.length != 3 || t2.length != 3) {
            throw new InvalidTimeException("Timestamp must be in format HH:MM:SS\n");
        }
        int hour1 = Integer.parseInt(t1[0]);
        int min1 = Integer.parseInt(t1[1]);
        int sec1 = Integer.parseInt(t1[2]);

        int hour2 = Integer.parseInt(t2[0]);
        int min2 = Integer.parseInt(t2[1]);
        int sec2 = Integer.parseInt(t2[2]);

        if (hour1 < 0 || hour2 < 0)
            throw new InvalidTimeException("Hours must be greater than or equal to 0\n");
        if (hour1 >= 24 || hour2 >= 24)
            throw new InvalidTimeException("Hours must be less than 24\n");

        if (min1 < 0 || min2 < 0)
            throw new InvalidTimeException("Minutes must be greater than or equal to 0\n");
        if (min1 >= 60 || min2 >= 60)
            throw new InvalidTimeException("Minutes must be less than 60\n");
        if (sec1 < 0 || sec2 < 0)
            throw new InvalidTimeException("Seconds must be greater than or equal to 0\n");
        if (sec1 >= 60 || sec2 >= 60)
            throw new InvalidTimeException("Seconds must be less than 60\n");

        int time1 = hour1 * 3600 + min1 * 60 + sec1;
        int time2 = hour2 * 3600 + min2 * 60 + sec2;

        return time2 - time1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("[Time Calculator]");

        while (true) {
            System.out.println("1. Calculate difference in seconds");
            System.out.println("2. Exit");
            System.out.print("Enter your option: ");

            int options = input.nextInt();
            input.nextLine();

            if (options == 2) {
                System.out.println("\nShutting off...");
                break;
            }
            if (options == 1) {
                System.out.print("\nEnter the start timestamp: ");
                String start = input.nextLine();

                System.out.print("Enter the end timestamp: ");
                String end = input.nextLine();

                try {
                    int result = differenceInSeconds(start, end);
                    System.out.println("The difference between " + start + " and " + end + " is " + result + " seconds\n");
                } catch (NumberFormatException e) {
                    System.out.println("You must enter integers for the hours, minutes, and seconds\n");
                } catch (InvalidTimeException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
    input.close();
    }
}
