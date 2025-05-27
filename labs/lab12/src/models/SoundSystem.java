package models;

public class SoundSystem {
    private Boolean isPlaying = false;

    public void play() {
        if (this.isPlaying) {
            System.out.println("Music already on!");
            return;
        }
        this.isPlaying = true;
        System.out.println("Music on!");
    }

    public void stop() {
        if (!this.isPlaying) {
            System.out.println("Music already off!");
            return;
        }
        this.isPlaying = false;
        System.out.println("Music off!");
    }
}
