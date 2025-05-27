package models;
import commands.*;
import interfaces.Command;

import java.util.*;

public class HomeSystem {
    private Map<String, Command> commandRegistry = new HashMap<>();
    // registry for the commands
    // ideally we should make them register themselves, since that won't violate ocp
    // but for the sake of the exercise, I'll have all commands register at creation
    private Lights lights;
    private SoundSystem music;

    public HomeSystem(Lights lights, SoundSystem music) {
        this.lights = lights;
        this.music = music;
        commandRegistry.put("lights on", new LightsOnCommand(this.lights));
        commandRegistry.put("lights off", new LightsOffCommand(this.lights));
        commandRegistry.put("music on", new MusicOnCommand(this.music));
        commandRegistry.put("music off", new MusicOffCommand(this.music));
    }

    public void handleCommand(String command) {
        Command commandObj = commandRegistry.get(command);
        if (commandObj == null) {
            System.out.println("Unknown command!");
            return;
        }
        commandObj.execute();
    }
}
