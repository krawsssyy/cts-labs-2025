package builders;
import interfaces.Logger;

public class Car {
    // required attributes
    private final String make;
    private final String model;
    private final Integer year;
    private final String engine;
    private final String color;
    private final Integer seats;
    // optional attributes
    private final Boolean hasComputer;
    private final Boolean hasGPS;
    private final Boolean hasAirConditioning;
    private final Boolean hasAlloyWheels;

    // logger instance to adhere to DIP
    private final Logger logger;

    // private constructor only accessible via the builder
    private Car(CarBuilder carBuilder) {
        this.make = carBuilder.make;
        this.model = carBuilder.model;
        this.year = carBuilder.year;
        this.engine = carBuilder.engine;
        this.color = carBuilder.color;
        this.seats = carBuilder.seats;
        this.hasComputer = carBuilder.hasComputer;
        this.hasGPS = carBuilder.hasGPS;
        this.hasAirConditioning = carBuilder.hasAirConditioning;
        this.hasAlloyWheels = carBuilder.hasAllowWheels;
        this.logger = carBuilder.logger; // dependency injection

        this.logger.log("[LOG] Car created: " + this.toString());
    }

    @Override
    public String toString() {
        return this.year + " " + this.make + " " + this.model + " | Engine: " + this.engine +
                " | Color: " + this.color + " | Seats: " + this.seats + " | Computer: " + this.hasComputer +
                " | GPS: " + this.hasGPS + " | Air Conditioning: " + this.hasAirConditioning +
                " | Alloy Wheels: " + this.hasAlloyWheels;
    }

    // inner static builder class
    public static class CarBuilder {
        // required attributes
        private final String make;
        private final String model;
        private final Integer year;
        private final String engine;
        private final String color;
        private final Integer seats;
        // optional attributes with default values
        private Boolean hasComputer = false;
        private Boolean hasGPS = false;
        private Boolean hasAirConditioning = true;
        private Boolean hasAllowWheels = false;

        private final Logger logger;

        // constructor for the builder class with the required fields
        public CarBuilder(String make, String model, Integer year, String engine, String color, Integer seats, Logger logger) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.engine = engine;
            this.color = color;
            this.seats = seats;
            this.logger = logger; // dependency injection

            this.logger.log(
                    "[LOG] Car builder initialized with with required fields: " + make + ", " + model
                    + ", " + year + ", " + engine + ", " + color + ", " + seats
            );
        }

        public CarBuilder hasComputer(Boolean hasComputer) {
            this.hasComputer = hasComputer;
            this.logger.log("[LOG] Builder set computer: " + hasComputer);
            return this;
        }

        public CarBuilder hasGPS(Boolean hasGPS) {
            this.hasGPS = hasGPS;
            this.logger.log("[LOG] Builder set GPS: " + hasGPS);
            return this;
        }

        public CarBuilder hasAirConditioning(Boolean hasAirConditioning) {
            this.hasAirConditioning = hasAirConditioning;
            this.logger.log("[LOG] Builder set air conditioning: " + hasAirConditioning);
            return this;
        }

        public CarBuilder hasAlloyWheels(Boolean hasAlloyWheels) {
            this.hasAllowWheels = hasAlloyWheels;
            this.logger.log("[LOG] Builder set alloy wheels: " + hasAlloyWheels);
            return this;
        }

        // build method creates a Car instance.
        public Car build() {
            this.logger.log("[LOG] Builder build called!");
            // do some validations
            if (this.make.trim().isEmpty() || this.model.trim().isEmpty() ||
                    this.engine.trim().isEmpty() || this.color.trim().isEmpty()) {
                throw new IllegalStateException("Some of the required arguments for a Car are empty! Please try again.");
            }

            if (this.year < 1900 || this.seats < 1) {
                throw new IllegalStateException ("Some of the required arguments for a Car have invalid values! " +
                        "Please try again.");
            }

            return new Car(this);
        }
    }
}
