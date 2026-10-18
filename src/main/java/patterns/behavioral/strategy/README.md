# Strategy Pattern

**Category:** Behavioral

## Intent
Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

## Problem it solves
A shopping cart must support several ways of calculating shipping (standard, express, pickup, ...). Putting them all in one method with `if/else` makes it grow with every new option and impossible to extend without editing it.

## Example in this folder
Each shipping method implements `ShippingStrategy`. `ShoppingCart` receives a strategy and can switch to another at runtime, without changing its own code.

## Structure
- `ShippingStrategy` - strategy interface
- `StandardShipping`, `ExpressShipping`, `PickupShipping` - concrete strategies
- `ShoppingCart` - context
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/strategy/*.java
java -cp out patterns.behavioral.strategy.Main
```

Package: `patterns.behavioral.strategy`
