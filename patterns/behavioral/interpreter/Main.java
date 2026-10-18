package patterns.behavioral.interpreter;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();

        // A "pricing rule" written in the tiny language: (price * quantity) - discount
        Expression total = parser.parse("price quantity * discount -");
        Map<String, Double> order1 = Map.of("price", 20.0, "quantity", 3.0, "discount", 5.0);
        Map<String, Double> order2 = Map.of("price", 7.5, "quantity", 10.0, "discount", 0.0);

        System.out.println("Rule: price quantity * discount -");
        System.out.println("  order1 = " + total.interpret(order1));   // 55.0
        System.out.println("  order2 = " + total.interpret(order2));   // 75.0

        System.out.println("Rule: 100 rate 100 / * (percentage)");
        System.out.println("  rate 15 -> " + parser.parse("100 rate 100 / *").interpret(Map.of("rate", 15.0)));

        System.out.println("Error handling:");
        run(parser, "price +", Map.of("price", 1.0));
        run(parser, "1 0 /", Map.of());
        run(parser, "tax 2 *", Map.of());
        run(parser, "", Map.of());
    }

    private static void run(ExpressionParser parser, String source, Map<String, Double> vars) {
        try {
            System.out.println("  '" + source + "' = " + parser.parse(source).interpret(vars));
        } catch (RuntimeException e) {
            System.out.println("  '" + source + "' -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}
