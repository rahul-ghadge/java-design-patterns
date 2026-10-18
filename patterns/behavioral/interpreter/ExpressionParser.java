package patterns.behavioral.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Builds an expression tree from a postfix (reverse Polish) string such as "price qty * 5 +".
 * Postfix keeps the parser tiny so the focus stays on the Interpreter pattern itself.
 */
public class ExpressionParser {
    public Expression parse(String postfix) {
        if (postfix == null || postfix.isBlank()) {
            throw new IllegalArgumentException("expression must not be empty");
        }
        Deque<Expression> stack = new ArrayDeque<>();
        for (String token : postfix.trim().split("\\s+")) {
            if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) >= 0) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Malformed expression near '" + token + "'");
                }
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(new BinaryExpression(token.charAt(0), left, right));
            } else if (isNumber(token)) {
                stack.push(new NumberExpression(Double.parseDouble(token)));
            } else {
                stack.push(new VariableExpression(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Malformed expression: '" + postfix + "'");
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
