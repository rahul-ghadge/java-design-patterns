package patterns.creational.abstractfactory;

public class MacButton implements Button {
    @Override public String render(String label) { return "( " + label + " )"; }
}
