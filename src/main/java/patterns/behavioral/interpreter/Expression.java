package src.main.java.patterns.behavioral.interpreter;

import java.util.Map;

/** Abstract expression: every node of the grammar can interpret itself. */
public interface Expression {
    double interpret(Map<String, Double> variables);
}
