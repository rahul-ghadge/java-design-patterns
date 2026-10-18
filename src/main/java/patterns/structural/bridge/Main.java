package src.main.java.patterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basic remote + Television:");
        RemoteControl basic = new RemoteControl(new Television());
        basic.togglePower();
        basic.volumeUp();

        System.out.println("Advanced remote + Radio:");
        AdvancedRemoteControl advanced = new AdvancedRemoteControl(new Radio());
        advanced.togglePower();
        advanced.volumeDown();
        advanced.mute();

        System.out.println("Invalid volume:");
        try {
            new Television().setVolume(150);
        } catch (IllegalArgumentException e) {
            System.out.println("  rejected: " + e.getMessage());
        }
    }
}
