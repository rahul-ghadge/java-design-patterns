package patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        DocumentService editor = new DocumentServiceProxy("EDITOR");

        System.out.println("1st read of doc-1:");
        System.out.println("  -> " + editor.readDocument("doc-1"));

        System.out.println("2nd read of doc-1 (cached):");
        System.out.println("  -> " + editor.readDocument("doc-1"));

        System.out.println("Guest tries to read doc-2:");
        DocumentService guest = new DocumentServiceProxy("GUEST");
        try {
            guest.readDocument("doc-2");
        } catch (SecurityException e) {
            System.out.println("  -> denied: " + e.getMessage());
        }

        System.out.println("Editor reads a missing document:");
        try {
            editor.readDocument("doc-99");
        } catch (IllegalArgumentException e) {
            System.out.println("  -> error: " + e.getMessage());
        }
    }
}
