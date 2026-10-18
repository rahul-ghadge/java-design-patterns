package patterns.behavioral.command;

/** Receiver: the object that actually does the work. */
public class TextDocument {
    private final StringBuilder text = new StringBuilder();

    public void append(String s) { text.append(s); }

    /** Removes and returns the last {@code count} characters. */
    public String removeLast(int count) {
        if (count < 0 || count > text.length()) {
            throw new IllegalArgumentException("cannot remove " + count + " chars from text of length " + text.length());
        }
        int start = text.length() - count;
        String removed = text.substring(start);
        text.delete(start, text.length());
        return removed;
    }

    public String getText() { return text.toString(); }
}
