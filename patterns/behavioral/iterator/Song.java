package patterns.behavioral.iterator;

public record Song(String title, String artist) {
    public Song {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title required");
    }

    @Override
    public String toString() { return title + " - " + artist; }
}
