package patterns.behavioral.chainofresponsibility;

public class Main {
    public static void main(String[] args) {
        // Build the chain: TeamLead -> Manager -> Director
        Approver chain = new TeamLead();
        chain.setNext(new Manager()).setNext(new Director());

        submit(chain, new ExpenseRequest("Asha", "Team lunch", 250));
        submit(chain, new ExpenseRequest("Ben", "Conference ticket", 2_400));
        submit(chain, new ExpenseRequest("Chitra", "New servers", 15_000));
        submit(chain, new ExpenseRequest("Dev", "Office renovation", 80_000));

        try {
            new ExpenseRequest("Eve", "Invalid", -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid request rejected: " + e.getMessage());
        }
    }

    private static void submit(Approver chain, ExpenseRequest request) {
        System.out.println("Request: " + request);
        chain.handle(request);
    }
}
