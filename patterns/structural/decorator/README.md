# Decorator Pattern

**Category:** Structural

## Intent
Attach additional responsibilities to an object dynamically, as a flexible alternative to subclassing.

## Problem it solves
A coffee shop offers many add-ons (milk, caramel, whipped cream) in any combination. Creating a subclass for every combination (`EspressoWithMilkAndCaramel`, ...) explodes in number.

## Example in this folder
Each add-on is a decorator that wraps a `Beverage` and adds to its description and cost. Add-ons are stacked at runtime: `new WhippedCream(new Caramel(new Espresso()))`.

## Structure
- `Beverage` - component interface; `Espresso` - concrete component
- `BeverageDecorator` - base decorator
- `Milk`, `Caramel`, `WhippedCream` - concrete decorators
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/decorator/*.java
java -cp out patterns.structural.decorator.Main
```

Package: `patterns.structural.decorator`
