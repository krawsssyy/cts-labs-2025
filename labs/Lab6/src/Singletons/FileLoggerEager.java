package Singletons;
import java.io.*;
public class FileLoggerEager { // another variant of the signleton pattern
    // useful for removing usages of getInstance
    // simpler variant and recommended to be used
    // directly initializing the instance here removes the usage of getInstance
    public static FileLoggerEager instance = new FileLoggerEager("log.txt"); // made public such that other can access and use it
    private final String filename;

    // private constructor prevents instantiation from other classes.
    private FileLoggerEager(String filename) {
        this.filename = filename;
        System.out.println("[*] Logger initialized!");
    }

    public void log(String message) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(this.filename, true));
            pw.println(message);
            pw.close(); // close file after writing
        } catch (IOException e) {
            System.err.println("[*] Logging failed with error: " + e.getMessage());
        }
    }
}
