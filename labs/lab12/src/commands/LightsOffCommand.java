package commands;

import interfaces.Command;
import models.Lights;

public class LightsOffCommand implements Command {
    private Lights lights;

    public LightsOffCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        this.lights.turnOff();
    }
}
