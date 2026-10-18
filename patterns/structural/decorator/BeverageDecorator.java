package patterns.structural.decorator;

import java.util.Objects;

/** Base decorator: wraps another Beverage and delegates to it. */
public abstract class BeverageDecorator implements Beverage {
    protected final Beverage wrapped;

    protected BeverageDecorator(Beverage wrapped) {
        this.wrapped = Objects.requireNonNull(wrapped, "wrapped beverage must not be null");
    }

    @Override public String getDescription() { return wrapped.getDescription(); }
    @Override public double getCost() { return wrapped.getCost(); }
}
