package State;

public class RedTrafficLight implements ITrafficLightColor { // concrete state

    @Override
    public void change(TrafficLights lights) {
        lights.setColor(new GreenTrafficLight());
    }

    @Override
    public String get() {
        return "RED";
    }
}
