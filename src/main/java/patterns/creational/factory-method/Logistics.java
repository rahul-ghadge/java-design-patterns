package patterns.creational.factorymethod;

/**
 * Creator: contains business logic that works with a Transport, but leaves the
 * decision of WHICH Transport to create to its subclasses (the factory method).
 */
public abstract class Logistics {

    /** The factory method. */
    protected abstract Transport createTransport();

    public void planDelivery(String cargo) {
        if (cargo == null || cargo.isBlank()) throw new IllegalArgumentException("cargo required");
        System.out.println("Planning delivery of '" + cargo + "'");
        Transport transport = createTransport();   // subclass decides the concrete type
        transport.deliver(cargo);
    }
}
