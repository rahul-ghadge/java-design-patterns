# Abstract Factory Pattern

**Category:** Creational

## Intent
Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

## Problem it solves
A UI needs buttons and text fields that match the operating system's style. Creating widgets with `new WindowsButton()` / `new MacTextField()` throughout the code makes it easy to mix styles by mistake and hard to add a new platform.

## Example in this folder
`UiFactory` declares `createButton()` and `createTextField()`. `WindowsUiFactory` and `MacUiFactory` each produce a consistent family. `LoginForm` receives a factory and never names a concrete widget class.

## Structure
- `Button`, `TextField` - abstract products
- `WindowsButton`, `WindowsTextField`, `MacButton`, `MacTextField` - concrete products
- `UiFactory` - abstract factory; `WindowsUiFactory`, `MacUiFactory` - concrete factories
- `UiFactories` - helper that selects a factory by platform name
- `LoginForm` - client; `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/creational/abstractfactory/*.java
java -cp out patterns.creational.abstractfactory.Main
```

Package: `patterns.creational.abstractfactory` (the folder has hyphens, but Java package names cannot, so they are removed)
