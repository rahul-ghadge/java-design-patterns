# Facade Pattern

**Category:** Structural

## Intent
Provide a single, simplified interface to a set of interfaces in a subsystem.

## Problem it solves
Placing an order involves checking inventory, charging payment, reserving stock and creating a shipment. Making every client call these services in the right order is repetitive and error-prone.

## Example in this folder
`OrderFacade.placeOrder(...)` coordinates `InventoryService`, `PaymentService` and `ShippingService`. The client makes one call; the subsystem classes stay usable on their own.

## Structure
- `InventoryService`, `PaymentService`, `ShippingService` - subsystem classes
- `OrderFacade` - facade
- `Main` - demo (success, out of stock, payment declined, invalid input)

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/facade/*.java
java -cp out patterns.structural.facade.Main
```

Package: `patterns.structural.facade`
