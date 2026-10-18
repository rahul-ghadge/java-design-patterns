# Composite Pattern

**Category:** Structural

## Intent
Compose objects into tree structures and let clients treat individual objects and compositions uniformly.

## Problem it solves
A file system has files and folders; folders contain both. Without Composite, client code needs `instanceof` checks and recursion everywhere to compute sizes or print trees.

## Example in this folder
`FileItem` (leaf) and `Folder` (composite) both implement `FileSystemItem`. Calling `getSizeKb()` or `print()` on a folder recursively delegates to its children.

## Structure
- `FileSystemItem` - component interface
- `FileItem` - leaf
- `Folder` - composite
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/composite/*.java
java -cp out patterns.structural.composite.Main
```

Package: `patterns.structural.composite`
