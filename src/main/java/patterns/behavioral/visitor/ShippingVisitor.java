package src.main.java.patterns.behavioral.visitor;

/** Concrete visitor #2: a completely different operation, added without touching the item classes. */
public class ShippingVisitor implements ItemVisitor<Double> {
    @Override public Double visit(Book book) { return 2.00; }
    @Override public Double visit(Electronics electronics) { return 5.00 + 2.00 * electronics.weightKg(); }
    @Override public Double visit(Grocery grocery) { return 3.50; }
}
