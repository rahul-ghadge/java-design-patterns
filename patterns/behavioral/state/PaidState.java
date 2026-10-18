package patterns.behavioral.state;

class PaidState implements OrderState {
    @Override public void pay(Order order) { throw new IllegalStateException("Order is already paid"); }
    @Override public void ship(Order order) { order.setState(new ShippedState()); }
    @Override public void deliver(Order order) { throw new IllegalStateException("Cannot deliver before shipping"); }
    @Override public void cancel(Order order) {
        System.out.println("  (refunding payment)");
        order.setState(new CancelledState());
    }
    @Override public String name() { return "PAID"; }
}
