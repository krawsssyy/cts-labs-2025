package Observer;

public class Web implements IObserver {
    private Integer id;

    public Web(Integer id) {
        this.id = id;
    }

    @Override
    public void update(Float temperature, Float humidity, Float pressure) { // simple implementations
        System.out.println("Web observer with id " + this.id + " received new data:");
        System.out.format("Temperature: %f, Humidity: %f, Pressure: %f\n", temperature, humidity, pressure);
    }
}
