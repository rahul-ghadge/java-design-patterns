package patterns.creational.factorymethod;

public class Ship implements Transport {
    @Override public void deliver(String cargo) { System.out.println("  Ship delivers '" + cargo + "' by sea"); }
}
