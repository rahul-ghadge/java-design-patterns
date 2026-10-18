package patterns.creational.abstractfactory;

public class WindowsTextField implements TextField {
    @Override public String render(String placeholder) { return "|" + placeholder + "____|"; }
}
