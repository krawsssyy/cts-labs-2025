public class DVDPlayer {
    private Boolean on = false;
    private String movie = "";

    public void turnOn() {
        if (this.on) {
            System.out.println("Player already turned on!");
            return;
        }
        this.on = true;
        System.out.println("Turned DVDPlayer on!");
    }

    public void turnOff() {
        if (!this.on) {
            System.out.println("Player already turned off!");
            return;
        }
        this.on = false;
        System.out.println("Turned DVDPlayer off!");
    }

    public void play(String movie) {
        if (this.movie != "") {
            System.out.println("A movie is already playing!");
            return;
        }
        this.movie = movie;
        System.out.println("Playing: " + this.movie);
    }

    public void stop() {
        if (this.movie == "") {
            System.out.println("A movie is not playing!");
            return;
        }
        System.out.println("Stopped playing: " + this.movie);
        this.movie = "";
    }
}
