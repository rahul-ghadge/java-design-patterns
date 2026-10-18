package src.main.java.patterns.behavioral.state;

/** Context: delegates behaviour to its current state object. */
public class Order {
    private final String id;
    private OrderState state = new NewState();

    public Order(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        this.id = id;
        System.out.println("  Order " + id + " created (" + state.name() + ")");
    }

    void setState(OrderState newState) {
        System.out.println("  Order " + id + ": " + state.name() + " -> " + newState.name());
        this.state = newState;
    }

    public void pay() { state.pay(this); }
    public void ship() { state.ship(this); }
    public void deliver() { state.deliver(this); }
    public void cancel() { state.cancel(this); }

    public String getStatus() { return state.name(); }
}
