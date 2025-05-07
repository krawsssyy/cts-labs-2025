public class HomeTheatreFacade {
    private DVDPlayer player;
    private SoundSystem sound;
    private Lights lights;
    private Screen screen;

    public HomeTheatreFacade() {
        this.player = new DVDPlayer();
        this.sound = new SoundSystem();
        this.lights = new Lights();
        this.screen = new Screen();
    }

    public void watchMovie(String movie) {
        this.player.turnOn();
        this.sound.turnOn();
        for (Integer i = this.lights.brightness / 10; i > 0; i--) {
            this.lights.dim();
        }
        this.screen.down();
        this.sound.setSource("DVDPlayer");
        this.sound.setVolume(80);
        this.player.play(movie);
    }

    public void endMovie() {
        this.player.stop();
        this.player.turnOff();
        this.sound.turnOff();
        this.screen.up();
        for (Integer i = 0; i < 5; i++) {
            this.lights.brighten();
        }
    }

    public void listenMusic() {
        this.sound.turnOn();
        this.sound.setVolume(100);
        this.sound.setSource("Audio");
        this.screen.up();
    }

    public void endMusic() {
        this.sound.setVolume(30);
        this.sound.turnOff();
    }
}
