package src.main.java.patterns.behavioral.state;

class DeliveredState implements OrderState {
    @Override public void pay(Order order) { throw new IllegalStateException("Order is already completed"); }
    @Override public void ship(Order order) { throw new IllegalStateException("Order is already completed"); }
    @Override public void deliver(Order order) { throw new IllegalStateException("Order is already delivered"); }
    @Override public void cancel(Order order) { throw new IllegalStateException("Cannot cancel a delivered order"); }
    @Override public String name() { return "DELIVERED"; }
}
