package patterns.structural.bridge;

/** Refined abstraction: adds features on top of the basic remote. */
public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("  (muting " + device.getName() + ")");
        device.setVolume(0);
    }
}
