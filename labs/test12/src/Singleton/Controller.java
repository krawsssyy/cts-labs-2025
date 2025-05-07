package Singleton;

import java.io.*;

public class Controller extends AbstractController {
    public static Controller instance = new Controller(); // eager singleton

    @Override
    public void Initialize(String pathToConfig, Boolean isDebug) throws IOException {
        if (this.isRunning) {
            System.out.println("[*] Controller is already running!");
            return;
        }

        this.isRunning = true;
        this.isDebug = isDebug;
        this.pathToConfig = pathToConfig;

        File fileIn = new File(this.pathToConfig);
        if (fileIn.isFile()) {
            System.out.println("[*] Found config file!");
            FileInputStream fileInputStr = new FileInputStream(fileIn);
            DataInputStream dataInputStr = new DataInputStream(fileInputStr);

            this.controllerName = dataInputStr.readLine();
            this.pathToController = dataInputStr.readLine();

            dataInputStr.close();
            fileInputStr.close();
        }
        else {
            this.controllerName = this.pathToController = "";
            System.out.println("[*] Didn't find config file!");
        }

        if (this.isDebug) {
            System.out.println("[*] Engine started!");
            System.out.println("[LOG] Path to config: " + this.pathToConfig);
            System.out.println("[LOG] Controller name: " + this.controllerName);
            System.out.println("[LOG] Path to controller: " + this.pathToController);
        }
    }

    @Override
    public void Shutdown() {
        if (!this.isRunning) {
            System.out.println("[*] Controller already stopped!");
            return;
        }

        this.isRunning = false;
        this.pathToConfig = this.pathToController = this.controllerName = "";

        if (this.isDebug) {
            System.out.println("[*] Stopped controller! All values are reset to their default.");
        }

        this.isDebug = false;
    }
}
