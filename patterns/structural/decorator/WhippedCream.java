package patterns.structural.decorator;

public class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage wrapped) { super(wrapped); }

    @Override public String getDescription() { return wrapped.getDescription() + ", Whipped Cream"; }
    @Override public double getCost() { return wrapped.getCost() + 0.60; }
}
