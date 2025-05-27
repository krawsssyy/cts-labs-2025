package commands;

import interfaces.Command;
import models.Lights;

public class LightsOnCommand implements Command {
    private Lights lights;

    public LightsOnCommand(Lights lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        this.lights.turnOn();
    }
}
