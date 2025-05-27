package commands;

import interfaces.Command;
import models.SoundSystem;

public class MusicOnCommand implements Command {
    private SoundSystem music;

    public MusicOnCommand(SoundSystem music) {
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.play();
    }
}
