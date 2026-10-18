package patterns.behavioral.state;

class CancelledState implements OrderState {
    @Override public void pay(Order order) { throw new IllegalStateException("Order is cancelled"); }
    @Override public void ship(Order order) { throw new IllegalStateException("Order is cancelled"); }
    @Override public void deliver(Order order) { throw new IllegalStateException("Order is cancelled"); }
    @Override public void cancel(Order order) { throw new IllegalStateException("Order is already cancelled"); }
    @Override public String name() { return "CANCELLED"; }
}
