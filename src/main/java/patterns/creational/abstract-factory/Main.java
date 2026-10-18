package patterns.creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        for (String platform : new String[] {"windows", "macos"}) {
            System.out.println("Login form on " + platform + ":");
            new LoginForm(UiFactories.forPlatform(platform)).display();
        }

        try {
            UiFactories.forPlatform("amiga");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
