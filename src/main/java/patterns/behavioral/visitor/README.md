# Visitor Pattern

**Category:** Behavioral

## Intent
Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements it operates on.

## Problem it solves
A cart contains different item types (`Book`, `Electronics`, `Grocery`), and you need operations such as tax and shipping calculation that depend on the type. Adding each operation as a method to every item class keeps modifying them.

## Example in this folder
Each item has a single `accept(visitor)` method. `TaxVisitor` and `ShippingVisitor` each implement one `visit` method per item type, so new operations are added as new visitor classes without editing the items.

## Structure
- `ItemVisitor<R>` - visitor interface; `TaxVisitor`, `ShippingVisitor` - concrete visitors
- `Item` - element interface; `Book`, `Electronics`, `Grocery` - concrete elements
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/visitor/*.java
java -cp out patterns.behavioral.visitor.Main
```

Package: `patterns.behavioral.visitor`
