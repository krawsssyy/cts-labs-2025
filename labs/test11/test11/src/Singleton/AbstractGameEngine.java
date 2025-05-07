package Singleton;

import java.io.IOException;

public abstract class AbstractGameEngine {
    protected String pathToConfig;
    protected String pathToEngine;
    protected String engineName;
    protected Boolean isRunning = false;
    protected Boolean isDebug;

    // reads in from the file provided in pathToConfig
    // supposed config file will contain on the first line the engines' name, and on the second one is a path to the engine's executable
    // this function will read the values from the file and set them to the according attributes (also set isRunning to true)
    // it will also log the actions undertook to the console, if isDebug is true
    // if the engine is already running, halt all other actions and print a message to the screen
    public abstract void StartEngine(String pathToConfig, Boolean isDebug) throws IOException;
    // this function will set all values to their defaults, and render the engine not running
    // (also logs it if isDebug is true)
    public abstract void StopEngine();

    // mock for executing commands, such as sending an object to the engine
    public Boolean ExecuteCommand(String command) {
        System.out.println("[*] Command " + command + " successfully executed on the game engine!");
        return true;
    }

    public void SetNewConfig(String pathToConfig) {
        this.pathToConfig = pathToConfig;
    }

    public String GetEnginePath() {
        return this.pathToEngine;
    }

    public String GetEngineName() {
        return this.engineName;
    }

    public Boolean IsRunning() {
        return this.isRunning;
    }
}