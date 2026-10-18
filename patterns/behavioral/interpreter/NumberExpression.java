package patterns.behavioral.interpreter;

import java.util.Map;

/** Terminal expression: a literal number. */
public class NumberExpression implements Expression {
    private final double value;

    public NumberExpression(double value) { this.value = value; }

    @Override
    public double interpret(Map<String, Double> variables) { return value; }
}
