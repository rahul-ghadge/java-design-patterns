# Factory Method Pattern

**Category:** Creational

## Intent
Define an interface for creating an object, but let subclasses decide which class to instantiate.

## Problem it solves
A logistics application plans deliveries, but the kind of vehicle depends on the type of logistics (road or sea). If `planDelivery` created `new Truck()` directly, adding ships would mean editing it and filling it with `if/else` checks.

## Example in this folder
`Logistics.planDelivery(...)` calls the abstract factory method `createTransport()`. `RoadLogistics` returns a `Truck`; `SeaLogistics` returns a `Ship`. Adding air freight means adding one new subclass and one new transport.

## Structure
- `Transport` - product interface; `Truck`, `Ship` - concrete products
- `Logistics` - creator with the factory method; `RoadLogistics`, `SeaLogistics` - concrete creators
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/creational/factory-method/*.java
java -cp out patterns.creational.factorymethod.Main
```

Package: `patterns.creational.factorymethod` (the folder has hyphens, but Java package names cannot, so they are removed)
