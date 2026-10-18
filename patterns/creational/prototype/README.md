# Prototype Pattern

**Category:** Creational

## Intent
Specify the kinds of objects to create using a prototypical instance, and create new objects by copying it.

## Problem it solves
Configuring a server (CPU, memory, ports, environment variables) takes many steps. Most servers are the same with small differences, so rebuilding each one from scratch is repetitive.

## Example in this folder
`ServerSpec` implements `Prototype<ServerSpec>` and its `copy()` makes a **deep** copy (its lists and maps are copied, not shared). `ServerSpecRegistry` stores ready-made prototypes; clients request a copy and customize it. Note: the example uses a copy constructor rather than `Cloneable`/`clone()`, which is error-prone.

## Structure
- `Prototype<T>` - prototype interface
- `ServerSpec` - concrete prototype (deep copy)
- `ServerSpecRegistry` - prototype registry
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/creational/prototype/*.java
java -cp out patterns.creational.prototype.Main
```

Package: `patterns.creational.prototype`
