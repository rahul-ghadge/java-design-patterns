# Singleton Pattern

**Category:** Creational

## Intent
Ensure a class has only one instance and provide a global point of access to it.

## Problem it solves
Some resources must be shared by the whole application, such as a logger, a configuration, or a connection pool. Creating several instances would split the state (e.g. log messages scattered across several loggers) or waste resources.

## Example in this folder
`ApplicationLogger` has a private constructor and exposes `getInstance()`. It uses the initialization-on-demand holder idiom, which is lazy and thread-safe without explicit locking. The demo requests the instance from 8 threads and confirms that only one exists. (An `enum` with a single constant is another safe way to write a singleton in Java.)

## Structure
- `ApplicationLogger` - the singleton (with a private nested `Holder`)
- `Main` - demo, including a multi-threaded check

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/creational/singleton/*.java
java -cp out patterns.creational.singleton.Main
```

Package: `patterns.creational.singleton`
