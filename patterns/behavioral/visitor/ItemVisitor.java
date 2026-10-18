package patterns.behavioral.visitor;

/** Visitor: one visit method per concrete element type. R is the result type. */
public interface ItemVisitor<R> {
    R visit(Book book);
    R visit(Electronics electronics);
    R visit(Grocery grocery);
}
