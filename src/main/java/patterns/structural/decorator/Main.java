package src.main.java.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Beverage plain = new Espresso();
        print(plain);

        // Add behaviour at runtime by wrapping, in any combination or order.
        Beverage latte = new Milk(new Espresso());
        print(latte);

        Beverage fancy = new WhippedCream(new Caramel(new Milk(new Espresso())));
        print(fancy);

        Beverage doubleCaramel = new Caramel(new Caramel(new Espresso()));
        print(doubleCaramel);

        try {
            new Milk(null);
        } catch (NullPointerException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }

    private static void print(Beverage beverage) {
        System.out.printf("%-45s $%.2f%n", beverage.getDescription(), beverage.getCost());
    }
}
