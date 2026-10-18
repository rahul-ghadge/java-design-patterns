package patterns.structural.decorator;

/** Component: anything that can be ordered and priced. */
public interface Beverage {
    String getDescription();
    double getCost();
}
