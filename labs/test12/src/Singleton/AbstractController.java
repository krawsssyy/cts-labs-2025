package Singleton;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractController {
    protected String pathToConfig;
    protected String pathToController;
    protected String controllerName;
    protected Boolean isRunning = false;
    protected Boolean isDebug;

    // reads in from the file provided in pathToConfig
    // supposed config file will contain on the first line the controller's name, and on the second one is a path to the controller's executable
    // this function will read the values from the file and set them to the according attributes
    // log the actions undertook to the console, if isDebug is true
    // if the controller is already running, halt all other actions and print a message to the screen
    public abstract void Initialize(String pathToConfig, Boolean isDebug) throws IOException;
    // this function will set all values to their defaults, and render the controller not running
    // (also logs it if isDebug is true)
    public abstract void Shutdown();

    public Boolean Publish(Integer id, byte[] htmlData) {
        System.out.println("[*] Published webpage with id " + id + " successfully!");
        return true;
    }

    public Boolean Unpublish(Integer id) {
        System.out.println("[*] Unpublished webpage with id " + id + " successfully!");
        return true;
    }

    public void SetNewConfig(String pathToConfig) {
        this.pathToConfig = pathToConfig;
    }

    public String GetControllerPath() {
        return this.pathToController;
    }

    public String GetControllerName() {
        return this.controllerName;
    }

    public Boolean IsRunning() {
        return this.isRunning;
    }

}
