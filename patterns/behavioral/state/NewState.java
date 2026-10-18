package patterns.behavioral.state;

class NewState implements OrderState {
    @Override public void pay(Order order) { order.setState(new PaidState()); }
    @Override public void ship(Order order) { throw new IllegalStateException("Cannot ship an unpaid order"); }
    @Override public void deliver(Order order) { throw new IllegalStateException("Cannot deliver an unpaid order"); }
    @Override public void cancel(Order order) { order.setState(new CancelledState()); }
    @Override public String name() { return "NEW"; }
}
