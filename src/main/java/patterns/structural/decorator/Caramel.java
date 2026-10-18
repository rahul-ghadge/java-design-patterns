package src.main.java.patterns.structural.decorator;

public class Caramel extends BeverageDecorator {
    public Caramel(Beverage wrapped) { super(wrapped); }

    @Override public String getDescription() { return wrapped.getDescription() + ", Caramel"; }
    @Override public double getCost() { return wrapped.getCost() + 0.75; }
}
