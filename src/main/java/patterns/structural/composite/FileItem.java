package src.main.java.patterns.structural.composite;

/** Leaf: a single file. */
public class FileItem implements FileSystemItem {
    private final String name;
    private final long sizeKb;

    public FileItem(String name, long sizeKb) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be blank");
        if (sizeKb < 0) throw new IllegalArgumentException("size must not be negative: " + sizeKb);
        this.name = name;
        this.sizeKb = sizeKb;
    }

    @Override public String getName() { return name; }
    @Override public long getSizeKb() { return sizeKb; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "- " + name + " (" + sizeKb + " KB)");
    }
}
