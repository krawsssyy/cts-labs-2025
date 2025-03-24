public class Logger {
    private static Logger instance = null;

    // simple private constructor
    private Logger() {
        System.out.println("[*] Logger initialized!");
    }

    // lazy synchronized initialization for ensuring some safety in multi-threaded environments
    public static synchronized Logger getInstance() {
        if (instance == null) { // if no instance was created, create it - ensure unicity
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}