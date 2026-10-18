package patterns.behavioral.visitor;

public record Electronics(String name, double price, double weightKg) implements Item {
    public Electronics {
        if (price < 0) throw new IllegalArgumentException("price must not be negative");
        if (weightKg <= 0) throw new IllegalArgumentException("weight must be positive");
    }

    @Override public <R> R accept(ItemVisitor<R> visitor) { return visitor.visit(this); }
}
