# Mediator Pattern

**Category:** Behavioral

## Intent
Define an object that encapsulates how a set of objects interact, so they do not need to refer to each other explicitly.

## Problem it solves
In a chat room, if every user held references to every other user, adding or removing a user would affect everyone and the code would become a tangled many-to-many web.

## Example in this folder
`ChatRoom` (the mediator) holds all `User`s. A user only calls `say(...)` or `whisper(...)`, and the room decides who receives the message.

## Structure
- `ChatMediator` - mediator interface; `ChatRoom` - concrete mediator
- `User` - colleague
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/mediator/*.java
java -cp out patterns.behavioral.mediator.Main
```

Package: `patterns.behavioral.mediator`
