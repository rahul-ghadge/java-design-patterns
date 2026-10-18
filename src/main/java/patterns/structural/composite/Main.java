package src.main.java.patterns.structural.composite;

public class Main {
    public static void main(String[] args) {
        Folder docs = new Folder("docs")
                .add(new FileItem("resume.pdf", 220))
                .add(new FileItem("notes.txt", 12));

        Folder photos = new Folder("photos")
                .add(new FileItem("beach.jpg", 3400))
                .add(new FileItem("city.jpg", 2800));

        Folder home = new Folder("home").add(docs).add(photos).add(new FileItem("todo.md", 1));

        // The client treats a single file and a whole tree uniformly.
        home.print("");
        System.out.println();
        System.out.println("Total size of 'home': " + home.getSizeKb() + " KB");
        System.out.println("Size of one file    : " + new FileItem("a.txt", 5).getSizeKb() + " KB");

        try {
            home.add(home);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
