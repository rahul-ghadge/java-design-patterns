package patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Aggregate: stores songs in a plain array (hidden from clients) and
 * hands out iterators to traverse them in different orders.
 * Implementing Iterable also enables the for-each loop.
 */
public class Playlist implements Iterable<Song> {
    private Song[] songs = new Song[2];
    private int size = 0;

    public void add(Song song) {
        if (song == null) throw new IllegalArgumentException("song must not be null");
        if (size == songs.length) {
            songs = java.util.Arrays.copyOf(songs, size * 2);
        }
        songs[size++] = song;
    }

    public int size() { return size; }

    /** Forward iterator (used by for-each). */
    @Override
    public Iterator<Song> iterator() {
        return new ForwardIterator();
    }

    /** Backward iterator. */
    public Iterator<Song> reverseIterator() {
        return new ReverseIterator();
    }

    private class ForwardIterator implements Iterator<Song> {
        private int index = 0;

        @Override public boolean hasNext() { return index < size; }

        @Override
        public Song next() {
            if (!hasNext()) throw new NoSuchElementException("end of playlist");
            return songs[index++];
        }
    }

    private class ReverseIterator implements Iterator<Song> {
        private int index = size - 1;

        @Override public boolean hasNext() { return index >= 0; }

        @Override
        public Song next() {
            if (!hasNext()) throw new NoSuchElementException("start of playlist");
            return songs[index--];
        }
    }
}
