package patterns.creational.prototype;

/** Prototype: an object that knows how to produce a copy of itself. */
public interface Prototype<T> {
    T copy();
}
