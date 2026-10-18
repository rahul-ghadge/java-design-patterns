package patterns.creational.abstractfactory;

public class WindowsButton implements Button {
    @Override public String render(String label) { return "[ " + label + " ]"; }
}
