package patterns.creational.factorymethod;

public class Main {
    public static void main(String[] args) {
        Logistics road = new RoadLogistics();
        road.planDelivery("furniture");

        Logistics sea = new SeaLogistics();
        sea.planDelivery("containers of electronics");

        try {
            road.planDelivery(" ");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
