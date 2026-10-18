# Bridge Pattern

**Category:** Structural

## Intent
Decouple an abstraction from its implementation so the two can vary independently.

## Problem it solves
With plain inheritance, 2 kinds of remotes x 2 kinds of devices would need 4 classes, and every new remote or device multiplies that. Bridge keeps two small hierarchies instead.

## Example in this folder
`RemoteControl` / `AdvancedRemoteControl` (abstraction) hold a reference to a `Device` (implementor). Any remote works with any device (`Television`, `Radio`).

## Structure
- `Device` - implementor interface; `AbstractDevice`, `Television`, `Radio` - concrete implementors
- `RemoteControl` - abstraction; `AdvancedRemoteControl` - refined abstraction
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/bridge/*.java
java -cp out patterns.structural.bridge.Main
```

Package: `patterns.structural.bridge`
