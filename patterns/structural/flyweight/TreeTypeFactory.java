package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/** Flyweight factory: returns an existing TreeType if one was already created. */
public class TreeTypeFactory {
    private final Map<String, TreeType> cache = new HashMap<>();

    public TreeType getTreeType(String species, String color, String textureName) {
        if (species == null || species.isBlank()) throw new IllegalArgumentException("species required");
        String key = species + "|" + color + "|" + textureName;
        return cache.computeIfAbsent(key, k -> {
            System.out.println("  (creating new TreeType: " + k + ")");
            return new TreeType(species, color, textureName);
        });
    }

    public int getCreatedTypeCount() {
        return cache.size();
    }
}
