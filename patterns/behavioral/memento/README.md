# Memento Pattern

**Category:** Behavioral

## Intent
Capture and externalize an object's internal state so it can be restored later, without violating encapsulation.

## Problem it solves
An editor needs undo. Exposing its internal text and cursor fields so another class can copy them would break encapsulation and tie that class to the editor's internals.

## Example in this folder
`TextEditor` (originator) creates opaque `Snapshot` objects of its content and cursor. `EditHistory` (caretaker) stores them on a stack but cannot look inside. Restoring a snapshot brings the editor back to that exact state.

## Structure
- `TextEditor` - originator (with nested `Snapshot` memento)
- `EditHistory` - caretaker
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/memento/*.java
java -cp out patterns.behavioral.memento.Main
```

Package: `patterns.behavioral.memento`
