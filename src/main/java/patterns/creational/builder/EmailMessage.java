package src.main.java.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Product: an immutable email. It can only be created through its {@link Builder},
 * which validates everything before an object ever exists.
 */
public final class EmailMessage {
    private final List<String> to;
    private final List<String> cc;
    private final String subject;
    private final String body;
    private final boolean highPriority;

    private EmailMessage(Builder builder) {
        this.to = Collections.unmodifiableList(new ArrayList<>(builder.to));
        this.cc = Collections.unmodifiableList(new ArrayList<>(builder.cc));
        this.subject = builder.subject;
        this.body = builder.body;
        this.highPriority = builder.highPriority;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "To: " + to
                + (cc.isEmpty() ? "" : "\n  Cc: " + cc)
                + "\n  Subject: " + (highPriority ? "[URGENT] " : "") + subject
                + "\n  Body: " + body;
    }

    /** Step-by-step construction with readable, chainable methods. */
    public static final class Builder {
        private final List<String> to = new ArrayList<>();
        private final List<String> cc = new ArrayList<>();
        private String subject;
        private String body = "";
        private boolean highPriority;

        private Builder() { }

        public Builder to(String address) { to.add(requireValidAddress(address)); return this; }
        public Builder cc(String address) { cc.add(requireValidAddress(address)); return this; }
        public Builder subject(String subject) { this.subject = subject; return this; }
        public Builder body(String body) { this.body = body; return this; }
        public Builder highPriority() { this.highPriority = true; return this; }

        public EmailMessage build() {
            if (to.isEmpty()) throw new IllegalStateException("at least one recipient is required");
            if (subject == null || subject.isBlank()) throw new IllegalStateException("subject is required");
            return new EmailMessage(this);
        }

        private static String requireValidAddress(String address) {
            if (address == null || !address.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
                throw new IllegalArgumentException("invalid email address: " + address);
            }
            return address;
        }
    }
}
