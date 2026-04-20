package Assignment7;

import java.util.Scanner;
import java.util.ArrayList;

public class Assignment7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("[Transaction Tallier]");

        System.out.print("\nEnter file name: ");
        String file = input.nextLine();

        ArrayList<String> transactions = TransactionReader.loadTransactions(file);

        if (transactions == null) {
            input.close();
            return;
        }
        System.out.println("Transactions loaded.");
        System.out.print("Create how many workers? ");
        int workerNum = input.nextInt();
        input.nextLine();

        TransactionTallier tt = new TransactionTallier(transactions);

        TallyWorker[] workers = new TallyWorker[workerNum];

        for (int i = 0; i < workerNum; i++) {
            workers[i] = new TallyWorker(tt);
        }

        System.out.println("Workers created. Press 'enter' to start tallying...");
        input.nextLine();

        System.out.println("\nStarting workers...");

        for (TallyWorker w : workers) {
            w.start();
        }

        for (TallyWorker w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nAll workers are done working.");
        System.out.println("Transaction total is $" + tt.getRunningTotal());
        System.out.println("\nCategories and their quantities:");

        for (String key : tt.getCategories().keySet()) {
            System.out.println(key + ": " + tt.getCategories().get(key));
        }
        System.out.println("\nProgram complete.");

        input.close();
    }   
}
