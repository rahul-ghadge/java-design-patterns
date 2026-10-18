# Chain of Responsibility Pattern

**Category:** Behavioral

## Intent
Pass a request along a chain of handlers. Each handler decides either to process the request or to pass it to the next handler.

## Problem it solves
An expense request must be approved by someone with enough authority. Hard-coding `if/else` logic that knows every approver couples the sender to all receivers and makes the rules hard to change.

## Example in this folder
`TeamLead` (up to $1,000), `Manager` (up to $5,000) and `Director` (up to $20,000) are linked together. The client submits a request to the first approver and the chain does the rest. Requests above $20,000 fall off the end and are rejected.

## Structure
- `Approver` - abstract handler holding the `next` link
- `TeamLead`, `Manager`, `Director` - concrete handlers
- `ExpenseRequest` - the request
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/chain-of-responsibility/*.java
java -cp out patterns.behavioral.chainofresponsibility.Main
```

Package: `patterns.behavioral.chainofresponsibility` (the folder has hyphens, but Java package names cannot, so they are removed)
