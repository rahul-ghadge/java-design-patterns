package patterns.creational.singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Singleton using the "initialization-on-demand holder" idiom:
 *  - lazy: the instance is created only the first time getInstance() is called
 *  - thread-safe: guaranteed by the JVM's class-loading rules, no synchronization needed
 *  - the constructor is private, so nobody else can create instances
 */
public final class ApplicationLogger {

    private final List<String> messages = Collections.synchronizedList(new ArrayList<>());

    private ApplicationLogger() {
        System.out.println("  (ApplicationLogger created)");
    }

    private static final class Holder {
        private static final ApplicationLogger INSTANCE = new ApplicationLogger();
    }

    public static ApplicationLogger getInstance() {
        return Holder.INSTANCE;
    }

    public void log(String message) {
        if (message == null || message.isBlank()) throw new IllegalArgumentException("message required");
        messages.add(message);
    }

    public int messageCount() {
        return messages.size();
    }

    public List<String> getMessages() {
        synchronized (messages) {
            return List.copyOf(messages);
        }
    }
}
