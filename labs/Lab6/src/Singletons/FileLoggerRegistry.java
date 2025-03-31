package Singletons;
import java.util.*;
import java.io.*;

public class FileLoggerRegistry { // another variant of the singleton pattern
    // useful for providing parameters
    private static HashMap<String, FileLoggerRegistry> loggers = new HashMap<>();
    String filename;

    private FileLoggerRegistry(String filename) {
        this.filename = filename;
    }

    public static synchronized FileLoggerRegistry  getInstance(String filename) {
        FileLoggerRegistry instance = loggers.get(filename);
        // it uses a hash map to keep track of different logging parameters that we may have
        // useful for passing parameters to the singleton, and having each for each parameter
        if (instance == null) {
            instance = new FileLoggerRegistry(filename);
            loggers.put(filename, instance);
        }

        return instance;
    }

    // same logging method
    public void log(String message) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename, true));
            pw.println(message);
            pw.close(); // close file after writing
        } catch (IOException e) {
            System.err.println("[*] Logging failed with error: " + e.getMessage());
        }
    }
}
