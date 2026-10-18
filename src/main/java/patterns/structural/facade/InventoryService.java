package src.main.java.patterns.structural.facade;

import java.util.HashMap;
import java.util.Map;

/** Subsystem class #1: tracks stock levels. */
public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("LAPTOP", 5);
        stock.put("MOUSE", 0);
    }

    public boolean isAvailable(String sku, int quantity) {
        return stock.getOrDefault(sku, 0) >= quantity;
    }

    public void reserve(String sku, int quantity) {
        stock.merge(sku, -quantity, Integer::sum);
        System.out.println("  [Inventory] reserved " + quantity + " x " + sku);
    }
}
