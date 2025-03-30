import builders.Car;
import interfaces.Logger;
import models.FileLogger;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = FileLogger.getInstance();
        Logger loggerTest = FileLogger.getInstance();

        if (logger == loggerTest) {
            System.out.println("[*] Logger instances match!");
        }
        else {
            System.out.println("!! Error - [*] Logger instances don't match!! It must be some of them cosmic rays - look up SEE");
            return;
        }

        try { // clear file
            PrintWriter pw = new PrintWriter("log.txt");
            pw.close();
        } catch (IOException e) {
            System.err.println("Could not clear log file: " + e.getMessage());
        }

        Car car = new Car.CarBuilder("Toyota", "Corolla", 2023, "1.8L I4", "Red", 5, logger)
                .hasComputer(true)
                .hasGPS(true)
                .hasAirConditioning(true)
                .hasAlloyWheels(false)
                .build();

        logger.log("[LOG] Test complete.");

        System.out.println("Created Car:");
        System.out.println(car);

        System.out.println("\nLog contents:");
        try {
            Scanner scanner = new Scanner(new File("log.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("[*] Error reading log file: " + e.getMessage());
        }
    }
}