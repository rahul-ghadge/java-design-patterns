# Command Pattern

**Category:** Behavioral

## Intent
Encapsulate a request as an object, so you can parameterize clients with different requests, queue or log them, and support undo.

## Problem it solves
A text editor needs undo. If the UI calls document methods directly, there is no record of what was done and no way to reverse it.

## Example in this folder
Each edit is a `Command` object (`AppendTextCommand`, `DeleteLastCharsCommand`) with `execute()` and `undo()`. `CommandHistory` runs them and keeps a stack, so undo is just popping and calling `undo()`.

## Structure
- `Command` - command interface
- `AppendTextCommand`, `DeleteLastCharsCommand` - concrete commands
- `TextDocument` - receiver
- `CommandHistory` - invoker
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/command/*.java
java -cp out patterns.behavioral.command.Main
```

Package: `patterns.behavioral.command`
