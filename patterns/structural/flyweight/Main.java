package patterns.structural.flyweight;

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();

        System.out.println("Planting trees:");
        for (int i = 0; i < 4; i++) {
            forest.plantTree(i * 10, i * 5, "Oak", "green", "oak.png");
        }
        for (int i = 0; i < 3; i++) {
            forest.plantTree(100 + i * 10, i * 7, "Pine", "dark green", "pine.png");
        }
        forest.plantTree(200, 200, "Oak", "orange", "oak_autumn.png");

        System.out.println("\nDrawing the forest:");
        forest.draw();

        System.out.println("\nTrees planted    : " + forest.getTreeCount());
        System.out.println("TreeType objects : " + forest.getTreeTypeCount() + "  (shared, not one per tree)");
    }
}
