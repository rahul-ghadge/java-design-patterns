# Java Design Patterns

All **23 Gang of Four (GoF) design patterns** implemented in plain Java, each with a small, runnable, real-world example.

- Plain **Java 17+**, standard JDK tools only (`javac` and `java`)
- No Maven, Gradle, JUnit, Spring Boot, or any external library
- Every pattern is independent: it lives in its own folder and package, with its own `README.md` and a `Main` class that demonstrates it

## Prerequisites

A JDK 17 or newer. Check with:

```bash
javac -version
java -version
```

## Repository layout

```
java-design-patterns/
├── README.md
└── patterns/
    ├── structural/    (7 patterns)
    ├── behavioral/    (11 patterns)
    └── creational/    (5 patterns)
```

Each pattern folder contains its `.java` files and a short `README.md` (intent, problem, structure, how to run).

## How to run a pattern

Run these commands from the repository root. Example for **Adapter**:

```bash
javac -d out patterns/structural/adapter/*.java
java -cp out patterns.structural.adapter.Main
```

The general form is:

```bash
javac -d out patterns/<category>/<folder>/*.java
java -cp out patterns.<category>.<package>.Main
```

> **Note on package names:** folders with hyphens (e.g. `chain-of-responsibility`) use the same name without hyphens as the Java package (`chainofresponsibility`), because hyphens are not allowed in Java identifiers. The table below lists the exact package for every pattern.

## Compile everything at once

```bash
find patterns -name "*.java" > sources.txt
javac -d out @sources.txt
```

(On Windows `cmd`: `dir /s /b patterns\*.java > sources.txt`, then `javac -d out @sources.txt`.)

## Run every demo in one go (bash)

```bash
for main in $(find out -name Main.class | sed 's|^out/||; s|\.class$||; s|/|.|g' | sort); do
  echo "=================== $main"
  java -cp out "$main"
done
```

## Patterns

### Structural patterns (how objects and classes are composed)

| # | Pattern | Example | Run |
|---|---------|---------|-----|
| 1 | [Adapter](src/main/java/patterns/structural/adapter/README.md) | Legacy payment gateway behind a `PaymentProcessor` interface | `java -cp out patterns.structural.adapter.Main` |
| 2 | [Bridge](src/main/java/patterns/structural/bridge/README.md) | Remote controls x devices (TV, radio) | `java -cp out patterns.structural.bridge.Main` |
| 3 | [Composite](src/main/java/patterns/structural/composite/README.md) | Files and folders with total size | `java -cp out patterns.structural.composite.Main` |
| 4 | [Decorator](src/main/java/patterns/structural/decorator/README.md) | Coffee with stackable add-ons | `java -cp out patterns.structural.decorator.Main` |
| 5 | [Facade](src/main/java/patterns/structural/facade/README.md) | One `placeOrder` call over inventory, payment and shipping | `java -cp out patterns.structural.facade.Main` |
| 6 | [Flyweight](src/main/java/patterns/structural/flyweight/README.md) | Thousands of trees sharing a few tree types | `java -cp out patterns.structural.flyweight.Main` |
| 7 | [Proxy](src/main/java/patterns/structural/proxy/README.md) | Access control + caching in front of a slow document service | `java -cp out patterns.structural.proxy.Main` |

### Behavioral patterns (how objects communicate and share responsibility)

| # | Pattern | Example | Run |
|---|---------|---------|-----|
| 8 | [Chain of Responsibility](src/main/java/patterns/behavioral/chain-of-responsibility/README.md) | Expense approval: team lead, manager, director | `java -cp out patterns.behavioral.chainofresponsibility.Main` |
| 9 | [Command](src/main/java/patterns/behavioral/command/README.md) | Text editing with undo | `java -cp out patterns.behavioral.command.Main` |
| 10 | [Interpreter](src/main/java/patterns/behavioral/interpreter/README.md) | Tiny postfix language for pricing rules | `java -cp out patterns.behavioral.interpreter.Main` |
| 11 | [Iterator](src/main/java/patterns/behavioral/iterator/README.md) | Playlist with forward and reverse iterators | `java -cp out patterns.behavioral.iterator.Main` |
| 12 | [Mediator](src/main/java/patterns/behavioral/mediator/README.md) | Chat room routing messages between users | `java -cp out patterns.behavioral.mediator.Main` |
| 13 | [Memento](src/main/java/patterns/behavioral/memento/README.md) | Editor snapshots for undo | `java -cp out patterns.behavioral.memento.Main` |
| 14 | [Observer](src/main/java/patterns/behavioral/observer/README.md) | Stock ticker with a price board and drop alerts | `java -cp out patterns.behavioral.observer.Main` |
| 15 | [State](src/main/java/patterns/behavioral/state/README.md) | Order lifecycle: new, paid, shipped, delivered, cancelled | `java -cp out patterns.behavioral.state.Main` |
| 16 | [Strategy](src/main/java/patterns/behavioral/strategy/README.md) | Swappable shipping-cost algorithms | `java -cp out patterns.behavioral.strategy.Main` |
| 17 | [Template Method](src/main/java/patterns/behavioral/template-method/README.md) | CSV and HTML report generators sharing one skeleton | `java -cp out patterns.behavioral.templatemethod.Main` |
| 18 | [Visitor](src/main/java/patterns/behavioral/visitor/README.md) | Tax and shipping operations over cart items | `java -cp out patterns.behavioral.visitor.Main` |

### Creational patterns (how objects are created)

| # | Pattern | Example | Run |
|---|---------|---------|-----|
| 19 | [Abstract Factory](src/main/java/patterns/creational/abstract-factory/README.md) | Windows/macOS UI widget families | `java -cp out patterns.creational.abstractfactory.Main` |
| 20 | [Builder](src/main/java/patterns/creational/builder/README.md) | Validated, immutable email message | `java -cp out patterns.creational.builder.Main` |
| 21 | [Factory Method](src/main/java/patterns/creational/factory-method/README.md) | Road and sea logistics creating different transports | `java -cp out patterns.creational.factorymethod.Main` |
| 22 | [Prototype](src/main/java/patterns/creational/prototype/README.md) | Deep-copying server configurations from a registry | `java -cp out patterns.creational.prototype.Main` |
| 23 | [Singleton](src/main/java/patterns/creational/singleton/README.md) | Thread-safe application logger | `java -cp out patterns.creational.singleton.Main` |

## Implementation notes

- Each example includes input validation and shows error handling in its `Main` demo.
- Each pattern uses only its own classes; no pattern depends on another.
- Small, idiomatic Java 17 features are used where they keep the code shorter (records, `switch` expressions); nothing beyond Java 17 is required.
- The `out/` directory created by `javac -d out` contains only compiled classes and can be deleted at any time.
