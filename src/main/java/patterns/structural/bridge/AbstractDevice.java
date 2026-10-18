package src.main.java.patterns.structural.bridge;

/** Shared state handling for concrete devices (keeps Television/Radio tiny). */
abstract class AbstractDevice implements Device {
    private final String name;
    private boolean on;
    private int volume = 30;

    protected AbstractDevice(String name) {
        this.name = name;
    }

    @Override public boolean isOn() { return on; }
    @Override public void powerOn() { on = true; System.out.println("  " + name + " is ON"); }
    @Override public void powerOff() { on = false; System.out.println("  " + name + " is OFF"); }
    @Override public int getVolume() { return volume; }
    @Override public String getName() { return name; }

    @Override
    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("volume must be between 0 and 100: " + volume);
        }
        this.volume = volume;
        System.out.println("  " + name + " volume = " + volume);
    }
}
