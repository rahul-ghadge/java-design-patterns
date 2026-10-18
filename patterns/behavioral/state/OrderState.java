package patterns.behavioral.state;

/**
 * State: each method is an action the customer or system can request.
 * Every concrete state decides what is allowed and what the next state is.
 */
public interface OrderState {
    void pay(Order order);
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
    String name();
}
