package patterns.behavioral.observer;

public class Main {
    public static void main(String[] args) {
        StockTicker ticker = new StockTicker();
        StockObserver board = new PriceBoard();
        StockObserver alert = new DropAlert(5);

        ticker.subscribe(board);
        ticker.subscribe(alert);

        ticker.listStock("ACME", 100.00);

        System.out.println("Both observers subscribed:");
        ticker.updatePrice("ACME", 104.00);
        ticker.updatePrice("ACME", 95.00);    // ~8.7% drop -> alert

        System.out.println("Board unsubscribed:");
        ticker.unsubscribe(board);
        ticker.updatePrice("ACME", 80.00);    // only the alert reacts

        try {
            ticker.updatePrice("ACME", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        try {
            ticker.updatePrice("UNKNOWN", 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
