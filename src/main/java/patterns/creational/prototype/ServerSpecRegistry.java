package src.main.java.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/** Registry of ready-made prototypes. Clients ask for a copy by key and then customize it. */
public class ServerSpecRegistry {
    private final Map<String, ServerSpec> prototypes = new HashMap<>();

    public void register(String key, ServerSpec prototype) {
        prototypes.put(key, prototype);
    }

    public ServerSpec create(String key) {
        ServerSpec prototype = prototypes.get(key);
        if (prototype == null) throw new IllegalArgumentException("No prototype registered for: " + key);
        return prototype.copy();
    }
}
