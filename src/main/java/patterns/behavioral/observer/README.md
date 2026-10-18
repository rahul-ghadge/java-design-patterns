# Observer Pattern

**Category:** Behavioral

## Intent
Define a one-to-many dependency so that when one object changes state, all its dependents are notified and updated automatically.

## Problem it solves
Several parts of an application (a price board, an alerting system, ...) need to react when a stock price changes. Having the ticker call each of them directly would couple it to all of them.

## Example in this folder
`StockTicker` (subject) keeps a list of `StockObserver`s. `PriceBoard` and `DropAlert` subscribe and are notified on every price update. Observers can be added or removed at runtime.

## Structure
- `StockObserver` - observer interface; `PriceBoard`, `DropAlert` - concrete observers
- `StockTicker` - subject
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/observer/*.java
java -cp out patterns.behavioral.observer.Main
```

Package: `patterns.behavioral.observer`
