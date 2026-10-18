package patterns.structural.composite;

/** Component: common interface for files and folders. */
public interface FileSystemItem {
    String getName();

    /** Size in kilobytes. */
    long getSizeKb();

    /** Prints this item (and children, if any) with the given indentation. */
    void print(String indent);
}
