package Assignment7;
public class TallyWorker extends Thread{
    private TransactionTallier tt;

    public TallyWorker(TransactionTallier tt) {
        this.tt = tt;
    }

    @Override
    public void run() {
        System.out.println("Worker " + Thread.currentThread().threadId() + " is about to start...");

        while (true) {

            String transaction = tt.getNextTransaction();
            if (transaction == null) break;
            
            String[] parts = transaction.split(" ");
            
            String type = parts[0];

            int price = Integer.parseInt(parts[parts.length - 1]);
            int quantity = Integer.parseInt(parts[parts.length - 2]);

            StringBuilder itemBuilder = new StringBuilder();
            for (int i = 1; i < parts.length - 2; i++) {
                itemBuilder.append(parts[i]);
                if (i < parts.length - 3) itemBuilder.append(" ");
            }
            String item = itemBuilder.toString();

            int cost = price * quantity;

            if (type.equalsIgnoreCase("sell")) {
                tt.addToTotal(cost);
            } else {
                tt.addToTotal(-cost);
            }

            tt.updateCategories(item, quantity);
        }

        System.out.println("Worker " + Thread.currentThread().threadId() + " is done working.");
    }
}