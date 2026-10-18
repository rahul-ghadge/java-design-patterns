package patterns.structural.bridge;

/** Implementor: the low-level device operations. */
public interface Device {
    boolean isOn();
    void powerOn();
    void powerOff();
    int getVolume();
    void setVolume(int volume);   // 0..100
    String getName();
}
