package commands;

import interfaces.Command;
import models.SoundSystem;

public class MusicOffCommand implements Command {
    private SoundSystem music;

    public MusicOffCommand(SoundSystem music) {
        this.music = music;
    }

    @Override
    public void execute() {
        this.music.stop();
    }
}
