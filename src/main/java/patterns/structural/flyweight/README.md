# Flyweight Pattern

**Category:** Structural

## Intent
Use sharing to support large numbers of fine-grained objects efficiently.

## Problem it solves
A game or map may contain hundreds of thousands of trees. If each tree stores its own species, color and texture data, memory runs out. Most of that data is identical between trees.

## Example in this folder
Shared, immutable data (`TreeType`: species, color, texture) is stored once and cached by `TreeTypeFactory`. Each `Tree` stores only its own position and a reference to the shared type. The demo plants 8 trees but creates only 3 `TreeType` objects.

## Structure
- `TreeType` - flyweight (intrinsic state)
- `TreeTypeFactory` - flyweight factory/cache
- `Tree` - context (extrinsic state: x, y)
- `Forest` - client
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/flyweight/*.java
java -cp out patterns.structural.flyweight.Main
```

Package: `patterns.structural.flyweight`
