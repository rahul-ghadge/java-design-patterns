# Proxy Pattern

**Category:** Structural

## Intent
Provide a surrogate or placeholder for another object to control access to it.

## Problem it solves
A document service is slow and holds sensitive data. Clients should not be able to read documents without permission, and repeated reads should not hit the slow service every time.

## Example in this folder
`DocumentServiceProxy` implements the same `DocumentService` interface as `RealDocumentService`. It checks the user's role (protection), caches results (caching) and creates the real service only when first needed (lazy initialization).

## Structure
- `DocumentService` - subject interface
- `RealDocumentService` - real subject
- `DocumentServiceProxy` - proxy
- `Main` - demo

## Compile and run
From the repository root (`java-design-patterns/`):

```bash
javac -d out patterns/structural/proxy/*.java
java -cp out patterns.structural.proxy.Main
```

Package: `patterns.structural.proxy`
