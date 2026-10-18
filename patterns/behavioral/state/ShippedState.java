package patterns.behavioral.state;

class ShippedState implements OrderState {
    @Override public void pay(Order order) { throw new IllegalStateException("Order is already paid"); }
    @Override public void ship(Order order) { throw new IllegalStateException("Order is already shipped"); }
    @Override public void deliver(Order order) { order.setState(new DeliveredState()); }
    @Override public void cancel(Order order) { throw new IllegalStateException("Cannot cancel an order that has shipped"); }
    @Override public String name() { return "SHIPPED"; }
}
