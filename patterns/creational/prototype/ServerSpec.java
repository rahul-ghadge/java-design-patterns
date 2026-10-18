package patterns.creational.prototype;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete prototype: a server configuration. It is mutable and contains collections,
 * so {@link #copy()} makes a DEEP copy - changing the clone must never affect the original.
 */
public class ServerSpec implements Prototype<ServerSpec> {
    private String name;
    private int cpuCores;
    private int memoryGb;
    private final List<Integer> openPorts;
    private final Map<String, String> environment;

    public ServerSpec(String name, int cpuCores, int memoryGb) {
        if (cpuCores <= 0 || memoryGb <= 0) throw new IllegalArgumentException("cpuCores and memoryGb must be positive");
        this.name = name;
        this.cpuCores = cpuCores;
        this.memoryGb = memoryGb;
        this.openPorts = new ArrayList<>();
        this.environment = new LinkedHashMap<>();
    }

    /** Copy constructor used by copy(): copies the collections instead of sharing them. */
    private ServerSpec(ServerSpec other) {
        this.name = other.name;
        this.cpuCores = other.cpuCores;
        this.memoryGb = other.memoryGb;
        this.openPorts = new ArrayList<>(other.openPorts);
        this.environment = new LinkedHashMap<>(other.environment);
    }

    @Override
    public ServerSpec copy() {
        return new ServerSpec(this);
    }

    public ServerSpec named(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.name = name;
        return this;
    }

    public ServerSpec openPort(int port) {
        if (port < 1 || port > 65535) throw new IllegalArgumentException("invalid port: " + port);
        openPorts.add(port);
        return this;
    }

    public ServerSpec env(String key, String value) {
        environment.put(key, value);
        return this;
    }

    public ServerSpec withMemoryGb(int memoryGb) {
        if (memoryGb <= 0) throw new IllegalArgumentException("memoryGb must be positive");
        this.memoryGb = memoryGb;
        return this;
    }

    @Override
    public String toString() {
        return name + " [" + cpuCores + " cores, " + memoryGb + " GB, ports=" + openPorts + ", env=" + environment + "]";
    }
}
