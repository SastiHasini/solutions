public class Logger {

    // 1. Static instance (only one object)
    private static Logger instance;

    // 2. Private constructor (prevents new object creation)
    private Logger() {
        System.out.println("Logger instance created");
    }

    // 3. Global access point
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // lazy initialization
        }
        return instance;
    }

    // Example method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}