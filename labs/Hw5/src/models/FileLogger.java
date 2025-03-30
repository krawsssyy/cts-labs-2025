package models;
import interfaces.Logger;
import java.io.*;

public class FileLogger implements Logger {
    private static volatile FileLogger instance; // volatile keyword required for synchronization for avoiding cache issues
    private final String filename = "log.txt"; // predefined log filename

    // private constructor prevents instantiation from other classes.
    private FileLogger() {
        System.out.println("[*] Logger initialized!");
    }

    // double-checked locking to ensure thread-safe singleton - another variant for multi-threaded safety
    public static FileLogger getInstance() {
        if (instance == null) {
            synchronized (FileLogger.class) { // you can use this or use a separate Object lock = new Object();
                if (instance == null) {
                    instance = new FileLogger();
                }
            }
        }
        return instance;
    }

    // log a message by appending it to the file.
    @Override
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
