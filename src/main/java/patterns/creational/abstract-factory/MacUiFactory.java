package patterns.creational.abstractfactory;

public class MacUiFactory implements UiFactory {
    @Override public Button createButton() { return new MacButton(); }
    @Override public TextField createTextField() { return new MacTextField(); }
}
