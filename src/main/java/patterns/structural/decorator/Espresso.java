package src.main.java.patterns.structural.decorator;

/** Concrete component: the plain drink. */
public class Espresso implements Beverage {
    @Override public String getDescription() { return "Espresso"; }
    @Override public double getCost() { return 2.00; }
}
