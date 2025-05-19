package Observer;

public class Phone implements IObserver {
    private Integer id;

    public Phone(Integer id) {
        this.id = id;

    }

    @Override
    public void update(Float temperature, Float humidity, Float pressure) { // simple implementations
        System.out.println("Phone observer with id " + this.id + " received new data:");
        System.out.format("Temperature: %f, Humidity: %f, Pressure: %f\n", temperature, humidity, pressure);
    }
}
