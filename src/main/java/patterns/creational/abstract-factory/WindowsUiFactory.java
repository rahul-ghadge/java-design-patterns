package patterns.creational.abstractfactory;

public class WindowsUiFactory implements UiFactory {
    @Override public Button createButton() { return new WindowsButton(); }
    @Override public TextField createTextField() { return new WindowsTextField(); }
}
