package patterns.behavioral.chainofresponsibility;

/**
 * Handler: approves requests up to its limit, otherwise forwards them
 * to the next approver in the chain.
 */
public abstract class Approver {
    private Approver next;
    private final String title;
    private final double limit;

    protected Approver(String title, double limit) {
        this.title = title;
        this.limit = limit;
    }

    /** Sets the next handler and returns it, so chains can be built fluently. */
    public Approver setNext(Approver next) {
        this.next = next;
        return next;
    }

    public final void handle(ExpenseRequest request) {
        if (request.amount() <= limit) {
            System.out.printf("  %s approved $%.2f for %s (%s)%n",
                    title, request.amount(), request.employee(), request.purpose());
        } else if (next != null) {
            System.out.printf("  %s cannot approve $%.2f -> forwarding%n", title, request.amount());
            next.handle(request);
        } else {
            System.out.printf("  %s cannot approve $%.2f -> REJECTED, no one left in the chain%n",
                    title, request.amount());
        }
    }
}
