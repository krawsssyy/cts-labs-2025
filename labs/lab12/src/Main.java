import models.*;
/*
refactor this code to adhere to the command design pattern

class Lights {
	Boolean isOn;
	public void turnOn(), turnOff();
}

class Music {
	Boolean isPlaying;
	public void play(), stop();
}

class HomeSystem {
	private Lights light;
	private Music music;
	public handleCommand(String command) {...}
}
*/
public class Main {
    public static void main(String[] args) {
        Lights lights = new Lights();
        SoundSystem music = new SoundSystem();
        HomeSystem system = new HomeSystem(lights, music);
        system.handleCommand("lights off");
        system.handleCommand("lights on");
        system.handleCommand("music on");
        system.handleCommand("music on");
        system.handleCommand("ac on"); // unknown command, just for testing
    }
}
