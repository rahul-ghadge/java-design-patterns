package patterns.behavioral.observer;

/** Observer: gets notified whenever a stock price changes. */
public interface StockObserver {
    void onPriceChanged(String symbol, double oldPrice, double newPrice);
}
