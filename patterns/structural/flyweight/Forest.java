package patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/** Client: plants many trees while reusing the shared tree types. */
public class Forest {
    private final List<Tree> trees = new ArrayList<>();
    private final TreeTypeFactory factory = new TreeTypeFactory();

    public void plantTree(int x, int y, String species, String color, String texture) {
        trees.add(new Tree(x, y, factory.getTreeType(species, color, texture)));
    }

    public void draw() {
        trees.forEach(Tree::draw);
    }

    public int getTreeCount() { return trees.size(); }
    public int getTreeTypeCount() { return factory.getCreatedTypeCount(); }
}
