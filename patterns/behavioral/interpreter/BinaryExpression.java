package patterns.behavioral.interpreter;

import java.util.Map;
import java.util.function.DoubleBinaryOperator;

/** Non-terminal expression: combines two sub-expressions with an operator. */
public class BinaryExpression implements Expression {
    private final Expression left;
    private final Expression right;
    private final char operator;

    public BinaryExpression(char operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Map<String, Double> variables) {
        double l = left.interpret(variables);
        double r = right.interpret(variables);
        return operation().applyAsDouble(l, r);
    }

    private DoubleBinaryOperator operation() {
        return switch (operator) {
            case '+' -> (a, b) -> a + b;
            case '-' -> (a, b) -> a - b;
            case '*' -> (a, b) -> a * b;
            case '/' -> (a, b) -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
            };
            default -> throw new IllegalStateException("Unknown operator: " + operator);
        };
    }
}
