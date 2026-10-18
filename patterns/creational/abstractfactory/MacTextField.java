package patterns.creational.abstractfactory;

public class MacTextField implements TextField {
    @Override public String render(String placeholder) { return "(" + placeholder + "....)"; }
}
