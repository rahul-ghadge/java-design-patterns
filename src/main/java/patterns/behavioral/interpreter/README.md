# Interpreter Pattern

**Category:** Behavioral

## Intent
Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

## Problem it solves
Business rules such as pricing formulas change often. Hard-coding each one in Java means recompiling for every change. A small rule language, interpreted at runtime, is more flexible.

## Example in this folder
A tiny postfix arithmetic language (`price quantity * discount -`). `ExpressionParser` turns text into a tree of `Expression` objects; calling `interpret(variables)` on the root evaluates the whole tree.

## Structure
- `Expression` - abstract expression
- `NumberExpression`, `VariableExpression` - terminal expressions
- `BinaryExpression` - non-terminal expression (+, -, *, /)
- `ExpressionParser` - builds the tree (client helper)
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/interpreter/*.java
java -cp out patterns.behavioral.interpreter.Main
```

Package: `patterns.behavioral.interpreter`
