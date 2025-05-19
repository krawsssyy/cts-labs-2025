package State;

public class YellowTrafficLight implements ITrafficLightColor { // concrete state

    @Override
    public void change(TrafficLights lights) {
        lights.setColor(new RedTrafficLight());
    }

    @Override
    public String get() {
        return "YELLOW";
    }
}
