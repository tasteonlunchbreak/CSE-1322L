package Lab4;
public class ParkWallet {
    private int tickets;
    private static boolean holiday = false;

    public ParkWallet() {
        this.tickets = 0;
    }
    public ParkWallet(int tickets) {
        this.tickets = tickets;
    }
    public int getTickets() {
        return tickets;
    }
    public static boolean getHoliday() {
        return holiday;
    }
    public void setTickets(int tickets) {
        if (tickets >= 0) {
            this.tickets = tickets;
        }
    }
    public static void setHoliday() {
        holiday = !holiday;
    }
    public void addTickets(int amount) {
        if (amount >= 0) {
            tickets += amount;
        }
    }
    public boolean removeTickets(int amount) {
        if (amount >= 0 && tickets >= amount) {
            tickets -= amount;
            return true;
        }
        return false;
    }
}
