package patterns.creational.factorymethod;

public class Truck implements Transport {
    @Override public void deliver(String cargo) { System.out.println("  Truck delivers '" + cargo + "' by road"); }
}
