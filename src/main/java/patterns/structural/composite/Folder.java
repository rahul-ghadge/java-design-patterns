package src.main.java.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/** Composite: a folder containing files and other folders. */
public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be blank");
        this.name = name;
    }

    public Folder add(FileSystemItem item) {
        if (item == null) throw new IllegalArgumentException("item must not be null");
        if (item == this) throw new IllegalArgumentException("a folder cannot contain itself");
        children.add(item);
        return this;
    }

    @Override public String getName() { return name; }

    @Override
    public long getSizeKb() {
        long total = 0;
        for (FileSystemItem child : children) {
            total += child.getSizeKb();       // works the same for files and folders
        }
        return total;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "+ " + name + "/ (" + getSizeKb() + " KB)");
        for (FileSystemItem child : children) {
            child.print(indent + "    ");
        }
    }
}
