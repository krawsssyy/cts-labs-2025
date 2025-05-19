import Observer.*;
import State.*;
import Strategy.*;

public class Main {
    public static void main(String[] args) {
        // State
        // the main object has different behaviours based on the internal state
        // in our case, the example is simple and nothing much happens, but the ideology behing still stands
        // the idea is that when the light is red, we abstract what might need to be changed to someone specialized
        // and the context just delegates that to a predefined state that knows how to handle itself based on itself (the current state)
        TrafficLights lights = new TrafficLights();
        lights.getState();
        lights.change();
        lights.getState();
        lights.change();
        lights.getState();
        lights.change();
        lights.getState();

        System.out.println();

        // Strategy
        // the main object provides the same functionality, but with different implementations
        // it has the same-ish behaviour but with different implementations
        // think of various sorts algorithms to be applied based on the type and formatting of the data
        // it provides a clean way of implementing that, using strategies
        // it uses an interface for generalizing the concrete implementations, and just sets the one necessary
        // it delegates the call to the specific strategy and knows how to deal with such data
        TextEditor editor = new TextEditor("Hello World!");
        editor.formatText();
        editor.setFormattingStrategy(new JavaStrategy());
        editor.formatText();
        editor.setFormattingStrategy(new MarkdownStrategy());
        editor.formatText();

        System.out.println();

        // Observer
        // implements the pub/sub paradigm (similar to event driven programming as well)
        // a publisher receives some sort of data
        // each publisher holds a list of subscribers to itself
        // (think of it as a youtube channel - you get notifications for new posts/videos)
        // each time new data is received by the publisher, the publisher notifies all subscribers (observers)
        // each observer does as he pleases with the data, and he can subscribe or unsubscribe at any time
        Phone phone1 = new Phone(1);
        Phone phone2 = new Phone(2);
        Web web = new Web(1);
        WeatherStation station = new WeatherStation();
        station.receiveData(10f, 0f, 0.5f);
        System.out.println();
        station.addObserver(phone1);
        station.addObserver(web);
        station.receiveData(11f, 1f, 1f);
        System.out.println();
        station.addObserver(phone2);
        station.receiveData(11f, 1.5f, 1f);
        System.out.println();
        station.removeObserver(phone1);
        station.receiveData(10f, 1.5f, 1f);
    }
}
