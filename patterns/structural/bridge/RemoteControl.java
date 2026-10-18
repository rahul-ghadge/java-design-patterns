package patterns.structural.bridge;

import java.util.Objects;

/** Abstraction: a basic remote that controls ANY {@link Device}. */
public class RemoteControl {
    protected final Device device;

    public RemoteControl(Device device) {
        this.device = Objects.requireNonNull(device, "device must not be null");
    }

    public void togglePower() {
        if (device.isOn()) device.powerOff(); else device.powerOn();
    }

    public void volumeUp() {
        device.setVolume(Math.min(100, device.getVolume() + 10));
    }

    public void volumeDown() {
        device.setVolume(Math.max(0, device.getVolume() - 10));
    }
}
