package Lab4;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("[Theme Park Wallet Manager]");

        ParkWallet wallet = new ParkWallet(100);
        boolean running = true;

        while (running) {
            if (ParkWallet.getHoliday()) {
                System.out.println("1. Add tickets");
                System.out.println("2. Set tickets");
                System.out.println("3. Buy prize at holiday prices!");
                System.out.println("4. Set holiday");
                System.out.println("5. Quit");
            } else {
                System.out.println("1. Add tickets");
                System.out.println("2. Set tickets");
                System.out.println("3. Buy prize");
                System.out.println("4. Set holiday");
                System.out.println("5. Quit");
            }
            System.out.println("Your wallet has " + wallet.getTickets() + " tickets");
            System.out.print("Enter option: ");
            int options = input.nextInt();

            switch (options) {
                case 1:
                    System.out.print("\nAdd how many tickets? ");
                    int add = input.nextInt();
                    wallet.addTickets(add);
                    break;
                case 2:
                    System.out.print("\nSet ticket balance to: ");
                    int set = input.nextInt();
                    wallet.setTickets(set);
                    break;
                case 3:
                    int tshirt = 150;
                    int sunhat = 350;
                    int sneakers = 600;

                    if (ParkWallet.getHoliday()) {
                        System.out.println("\nHoliday Prices!");
                        tshirt /= 2;
                        sunhat /= 2;
                        sneakers /= 2;
                    }
                    System.out.println("\n1. T-shirt (" + tshirt + " tickets)");
                    System.out.println("2. Sun hat (" + sunhat + " tickets)");
                    System.out.println("3. Sneakers (" + sneakers + " tickets)");
                    System.out.print("Buy which prize? ");
                    int prize = input.nextInt();

                    boolean success = false;
                    if (prize == 1) {
                        success = wallet.removeTickets(tshirt);
                        if (success) {
                            System.out.println("Bought a t-shirt for " + tshirt + " tickets");
                        } else {
                            System.out.println("Not enough tickets to buy a t-shirt");
                        }
                    }
                    else if (prize == 2) {
                        success = wallet.removeTickets(sunhat);
                        if (success) {
                            System.out.println("Bought a sun hat for " + sunhat + " tickets");
                        } else {
                            System.out.println("Not enough tickets to buy a sun hat");
                        }                       
                    }
                    else if (prize == 3) {
                        success = wallet.removeTickets(sneakers);
                        if (success) {
                            System.out.println("Bought sneakers for " + sneakers + " tickets");
                        } else {
                            System.out.println("Not enough tickets to buy sneakers");
                        }
                    }
                    break;
                case 4: 
                    ParkWallet.setHoliday();
                    if (ParkWallet.getHoliday()) {
                        System.out.println("\nIt is now a holiday."); 
                    } else {
                        System.out.println("\nIt is no longer a holiday.");
                    }
                    break;
                case 5:
                    System.out.println("\nShutting off...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println();
        }
        input.close();
        } 
    }
