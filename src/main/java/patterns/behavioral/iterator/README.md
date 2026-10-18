# Iterator Pattern

**Category:** Behavioral

## Intent
Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

## Problem it solves
A playlist stores songs in an array. Clients should be able to loop over the songs (forward or backward) without knowing it is an array, so the storage can change later without breaking them.

## Example in this folder
`Playlist` implements `Iterable<Song>` and returns its own `Iterator` implementations (`ForwardIterator`, `ReverseIterator`) as private inner classes. Clients use a normal for-each loop or `reverseIterator()`.

## Structure
- `Playlist` - aggregate (with two inner iterator classes)
- `Song` - element
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/iterator/*.java
java -cp out patterns.behavioral.iterator.Main
```

Package: `patterns.behavioral.iterator`
