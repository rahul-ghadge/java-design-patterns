package src.main.java.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Subject: holds prices and notifies subscribers when they change. */
public class StockTicker {
    private final Map<String, Double> prices = new HashMap<>();
    private final List<StockObserver> observers = new ArrayList<>();

    public void subscribe(StockObserver observer) {
        if (observer == null) throw new IllegalArgumentException("observer must not be null");
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    /** Lists a stock with its starting price. Does not notify observers. */
    public void listStock(String symbol, double initialPrice) {
        if (symbol == null || symbol.isBlank()) throw new IllegalArgumentException("symbol required");
        if (initialPrice <= 0) throw new IllegalArgumentException("price must be positive: " + initialPrice);
        prices.put(symbol, initialPrice);
    }

    public void updatePrice(String symbol, double newPrice) {
        Double oldPrice = prices.get(symbol);
        if (oldPrice == null) throw new IllegalArgumentException("Unknown stock: " + symbol);
        if (newPrice <= 0) throw new IllegalArgumentException("price must be positive: " + newPrice);

        prices.put(symbol, newPrice);
        // iterate over a copy so observers may unsubscribe while being notified
        for (StockObserver observer : new ArrayList<>(observers)) {
            observer.onPriceChanged(symbol, oldPrice, newPrice);
        }
    }
}
