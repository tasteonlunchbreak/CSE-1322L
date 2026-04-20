package Assignment7;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;
import java.util.ArrayList;

public class TransactionTallier {
    private ConcurrentLinkedQueue<String> transactions;
    private HashMap<String, Integer> categories;
    private int runningTotal;

    public TransactionTallier(ArrayList<String> transactions) {
        this.transactions = new ConcurrentLinkedQueue<>(transactions);
        this.categories = new HashMap<>();
        this.runningTotal = 0;
    }

    public synchronized void addToTotal(int value) {
        runningTotal += value;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getTransactionListSize() {
        return transactions.size();
    }

    public synchronized String getNextTransaction() {
        return transactions.poll();
    }

    public synchronized void updateCategories(String item, int amount) {
        categories.put(item, categories.getOrDefault(item,0) +  amount);
    }

    public HashMap<String, Integer> getCategories() {
        return categories;
    }
}