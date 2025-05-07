public class SoundSystem {
    private Boolean on = false;
    private String source = "";
    private Integer volume = 100;

    public void turnOn() {
        if (this.on) {
            System.out.println("Sound system already turned on!");
            return;
        }
        this.on = true;
        System.out.println("Turned sound system on!");
    }

    public void turnOff() {
        if (!this.on) {
            System.out.println("Sound system already turned off!");
            return;
        }
        this.on = false;
        System.out.println("Turned sound system off!");
    }

    public void setSource(String source) {
        this.source = source;
        System.out.println("Sound system source set to: " + this.source);
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
        System.out.println("Sound system volume set to: " + this.volume);
    }
}
