package patterns.creational.abstractfactory;

/** Abstract factory: creates a whole FAMILY of related widgets. */
public interface UiFactory {
    Button createButton();
    TextField createTextField();
}
