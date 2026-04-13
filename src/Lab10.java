import java.util.ArrayList;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Alarm> alarms = new ArrayList<>();
        System.out.println("[Alarm System]");

        while(true) {
            System.out.println("\n1. Create new alarm");
            System.out.println("2. View all alarms");
            System.out.println("3. Quit");
            System.out.print("Enter option: ");
            int option;

            try {
                option = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid option.");
                continue;
            }
            switch (option) {
                case 1:
                    try {
                        System.out.print("\nEnter alarm name: ");
                        String name = input.nextLine();

                        System.out.print("Enter alarm timer in seconds: ");
                        int seconds = Integer.parseInt(input.nextLine());

                        Alarm alarm = new Alarm(name, seconds);
                        alarms.add(alarm);

                        System.out.println(alarm);
                        alarm.start();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid timer: Timer must be a whole number.");
                    }
                    break;
                case 2:
                    System.out.println("\nHere are all the alarms still running: ");
                    for (Alarm alarm: alarms) {
                        if (alarm.isAlive()) {
                            System.out.println(alarm);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nStopping all alarms...");

                    for (Alarm alarm: alarms) {
                        if (alarm.isAlive()) {
                            alarm.interrupt();
                        }
                    }
                    for (Alarm alarm: alarms) {
                        try {
                            alarm.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("All alarms have been stopped.");
                    System.out.println("Shutting off...");
                    input.close();

                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
