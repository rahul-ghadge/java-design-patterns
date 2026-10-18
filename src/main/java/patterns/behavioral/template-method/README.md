# Template Method Pattern

**Category:** Behavioral

## Intent
Define the skeleton of an algorithm in a base class, deferring some steps to subclasses. Subclasses redefine certain steps without changing the algorithm's structure.

## Problem it solves
Generating a CSV report and an HTML report follows the same sequence (validate, header, rows, optional summary, footer). Copy-pasting that sequence into each generator duplicates logic and lets the order drift.

## Example in this folder
`ReportGenerator.generate(...)` is a `final` template method that fixes the order of steps. `CsvReportGenerator` and `HtmlReportGenerator` implement the abstract steps, and the HTML one overrides an optional hook (`includeSummary`) to add an extra step.

## Structure
- `ReportGenerator` - abstract class with the template method, abstract steps and hooks
- `CsvReportGenerator`, `HtmlReportGenerator` - concrete classes
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/behavioral/template-method/*.java
java -cp out patterns.behavioral.templatemethod.Main
```

Package: `patterns.behavioral.templatemethod` (the folder has hyphens, but Java package names cannot, so they are removed)
