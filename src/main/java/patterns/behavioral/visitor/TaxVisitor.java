package src.main.java.patterns.behavioral.visitor;

/** Concrete visitor #1: computes tax per item type (books 0%, groceries 5%, electronics 18%). */
public class TaxVisitor implements ItemVisitor<Double> {
    @Override public Double visit(Book book) { return book.price() * 0.00; }
    @Override public Double visit(Electronics electronics) { return electronics.price() * 0.18; }
    @Override public Double visit(Grocery grocery) { return grocery.price() * 0.05; }
}
