package patterns.structural.decorator;

public class Milk extends BeverageDecorator {
    public Milk(Beverage wrapped) { super(wrapped); }

    @Override public String getDescription() { return wrapped.getDescription() + ", Milk"; }
    @Override public double getCost() { return wrapped.getCost() + 0.50; }
}
