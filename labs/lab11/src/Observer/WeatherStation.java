package Observer;
import java.util.*;

public class WeatherStation { // unless we have multiple publishers, no need for an interface
    private Float temperature, humidity, pressure;
    private ArrayList<IObserver> observers = new ArrayList<>();
    // list for all observer
    // they register themselves whenever they want
    // whilst subscribed, each time the weather station receives an update, they will get notified
    // when they are done, they can unsubscribe so they won't receive any more updates

    public void receiveData(Float temperature, Float humidity, Float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.publish();
    }

    public void publish() {
        for (IObserver obs: this.observers) {
            obs.update(this.temperature, this.humidity, this.pressure);
        }
    }

    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

}
