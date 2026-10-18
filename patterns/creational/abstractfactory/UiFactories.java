package patterns.creational.abstractfactory;

/** Picks the right factory once; the rest of the program never mentions a concrete family. */
public final class UiFactories {
    private UiFactories() { }

    public static UiFactory forPlatform(String platform) {
        if (platform == null) throw new IllegalArgumentException("platform required");
        return switch (platform.toLowerCase()) {
            case "windows" -> new WindowsUiFactory();
            case "mac", "macos" -> new MacUiFactory();
            default -> throw new IllegalArgumentException("Unsupported platform: " + platform);
        };
    }
}
