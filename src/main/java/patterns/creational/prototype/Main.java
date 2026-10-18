package src.main.java.patterns.creational.prototype;

public class Main {
    public static void main(String[] args) {
        // Setting up a typical web server is "expensive": many settings.
        ServerSpec webTemplate = new ServerSpec("web-template", 4, 16)
                .openPort(80).openPort(443)
                .env("JAVA_OPTS", "-Xmx12g").env("REGION", "eu-west");

        ServerSpecRegistry registry = new ServerSpecRegistry();
        registry.register("web", webTemplate);

        // Clone and tweak instead of configuring from scratch.
        ServerSpec web1 = registry.create("web").named("web-1");
        ServerSpec web2 = registry.create("web").named("web-2").withMemoryGb(32).openPort(8080);

        System.out.println("template: " + webTemplate);
        System.out.println("web-1   : " + web1);
        System.out.println("web-2   : " + web2);

        // Proof of deep copy: the original is unaffected by changes to the clones.
        System.out.println("Same object? " + (web1 == webTemplate) + " (false = it is a real copy)");

        try {
            registry.create("database");
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
