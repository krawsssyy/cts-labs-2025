package Singleton;

import java.io.*;

public class GameEngine extends AbstractGameEngine {
    public static GameEngine instance = new GameEngine(); // eager singleton

    @Override
    public void StartEngine(String pathToConfig, Boolean isDebug) throws IOException {
        if (this.isRunning) {
            System.out.println("[*] Engine is already running!");
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

            this.engineName = dataInputStr.readLine();
            this.pathToEngine = dataInputStr.readLine();

            dataInputStr.close();
            fileInputStr.close();
        }
        else {
            this.engineName = this.pathToEngine = "";
            System.out.println("[*] Didn't find config file!");
        }

        if (this.isDebug) {
            System.out.println("[*] Engine started!");
            System.out.println("[LOG] Path to config: " + this.pathToConfig);
            System.out.println("[LOG] Engine name: " + this.engineName);
            System.out.println("[LOG] Path to engine: " + this.pathToEngine);
        }
    }

    @Override
    public void StopEngine() {
        if (!this.isRunning) {
            System.out.println("[*] Engine already stopped!");
            return;
        }

        this.isRunning = false;
        this.pathToConfig = this.pathToEngine = this.engineName = "";

        if (this.isDebug) {
            System.out.println("[*] Stopped engine! All values are reset to their default.");
        }

        this.isDebug = false;
    }
}
