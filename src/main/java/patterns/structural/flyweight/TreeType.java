package src.main.java.patterns.structural.flyweight;

/**
 * Flyweight: holds the INTRINSIC (shared, immutable) state of a tree.
 * Thousands of trees can share one TreeType instead of each storing this data.
 */
public final class TreeType {
    private final String species;
    private final String color;
    private final String textureName;   // imagine this refers to a large texture in memory

    TreeType(String species, String color, String textureName) {
        this.species = species;
        this.color = color;
        this.textureName = textureName;
    }

    /** Draws a tree of this type at the given position (extrinsic state is passed in). */
    public void draw(int x, int y) {
        System.out.println("  Drawing " + color + " " + species + " (" + textureName + ") at (" + x + ", " + y + ")");
    }
}
