# Adapter Pattern

**Category:** Structural

## Intent
Convert the interface of a class into another interface that clients expect, so incompatible classes can work together.

## Problem it solves
Your application depends on a `PaymentProcessor` interface, but the payment library you must use (`LegacyCardGateway`) has a different API (cents, card tokens, integer result codes) and cannot be changed.

## Example in this folder
A `LegacyGatewayAdapter` implements `PaymentProcessor` and translates dollars to cents and result codes to booleans, so the client code never sees the legacy API.

## Structure
- `PaymentProcessor` - Target interface
- `LegacyCardGateway` - Adaptee (incompatible class)
- `LegacyGatewayAdapter` - Adapter
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/adapter/*.java
java -cp out patterns.structural.adapter.Main
```

Package: `patterns.structural.adapter`
