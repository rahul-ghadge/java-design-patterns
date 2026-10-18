# Builder Pattern

**Category:** Creational

## Intent
Separate the construction of a complex object from its representation, so the same construction process can create different representations.

## Problem it solves
An email has several optional parts (cc, body, priority) and a few required ones. A constructor with many parameters (`new EmailMessage(to, cc, subject, body, true)`) is hard to read and easy to get wrong, and setters allow half-built, mutable objects.

## Example in this folder
`EmailMessage.builder()` returns a `Builder` with chainable methods. `build()` validates required fields and creates an immutable `EmailMessage`.

## Structure
- `EmailMessage` - immutable product with a nested `Builder`
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/creational/builder/*.java
java -cp out patterns.creational.builder.Main
```

Package: `patterns.creational.builder`
