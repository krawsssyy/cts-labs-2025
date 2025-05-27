package interfaces;

public interface Command {
    // give a common interface for commands, typically requiring a single function
    // if we were to pass parameters to it, we have multiple possibilities
    // use a map of the parameters and have it in the interface or use a factory for the commands
    public void execute();
}
