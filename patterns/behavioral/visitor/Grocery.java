package patterns.behavioral.visitor;

public record Grocery(String name, double price) implements Item {
    public Grocery {
        if (price < 0) throw new IllegalArgumentException("price must not be negative");
    }

    @Override public <R> R accept(ItemVisitor<R> visitor) { return visitor.visit(this); }
}
