package src.main.java.patterns.behavioral.interpreter;

import java.util.Map;

/** Terminal expression: a named variable looked up in the context. */
public class VariableExpression implements Expression {
    private final String name;

    public VariableExpression(String name) { this.name = name; }

    @Override
    public double interpret(Map<String, Double> variables) {
        Double value = variables.get(name);
        if (value == null) {
            throw new IllegalArgumentException("Undefined variable: " + name);
        }
        return value;
    }
}
