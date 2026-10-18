package patterns.creational.abstractfactory;

/** Client: builds a login form using only the abstract types, so the look always matches. */
public class LoginForm {
    private final TextField username;
    private final TextField password;
    private final Button submit;

    public LoginForm(UiFactory factory) {
        this.username = factory.createTextField();
        this.password = factory.createTextField();
        this.submit = factory.createButton();
    }

    public void display() {
        System.out.println("  " + username.render("username"));
        System.out.println("  " + password.render("password"));
        System.out.println("  " + submit.render("Log in"));
    }
}
