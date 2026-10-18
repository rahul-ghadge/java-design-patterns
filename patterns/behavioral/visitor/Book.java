package patterns.behavioral.visitor;

public record Book(String title, double price) implements Item {
    public Book {
        if (price < 0) throw new IllegalArgumentException("price must not be negative");
    }

    @Override public <R> R accept(ItemVisitor<R> visitor) { return visitor.visit(this); }
}
