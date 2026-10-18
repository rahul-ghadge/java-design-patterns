# State Pattern

**Category:** Behavioral

## Intent
Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

## Problem it solves
An order behaves differently depending on its status (you can cancel a new order but not a shipped one). Implementing this with big `if/switch` blocks on a status field spreads the rules across every method and becomes hard to extend.

## Example in this folder
Each status is a class (`NewState`, `PaidState`, `ShippedState`, `DeliveredState`, `CancelledState`) that implements `OrderState`. `Order` delegates every action to its current state, which either performs a valid transition or throws for an invalid one.

## Structure
- `OrderState` - state interface
- `NewState`, `PaidState`, `ShippedState`, `DeliveredState`, `CancelledState` - concrete states
- `Order` - context
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/state/*.java
java -cp out patterns.behavioral.state.Main
```

Package: `patterns.behavioral.state`
