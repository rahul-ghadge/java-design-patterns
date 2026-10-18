package patterns.behavioral.chainofresponsibility;

/** The request passed along the chain. */
public record ExpenseRequest(String employee, String purpose, double amount) {
    public ExpenseRequest {
        if (employee == null || employee.isBlank()) throw new IllegalArgumentException("employee required");
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive: " + amount);
    }
}
