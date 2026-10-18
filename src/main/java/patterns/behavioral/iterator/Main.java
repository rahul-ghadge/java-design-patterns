package src.main.java.patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.add(new Song("Blue in Green", "Miles Davis"));
        playlist.add(new Song("Take Five", "Dave Brubeck"));
        playlist.add(new Song("So What", "Miles Davis"));
        playlist.add(new Song("My Favorite Things", "John Coltrane"));   // forces the array to grow

        System.out.println("Forward (for-each):");
        for (Song song : playlist) {
            System.out.println("  " + song);
        }

        System.out.println("Backward:");
        Iterator<Song> it = playlist.reverseIterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }

        System.out.println("Calling next() past the end:");
        try {
            it.next();
        } catch (NoSuchElementException e) {
            System.out.println("  " + e.getMessage());
        }
    }
}
