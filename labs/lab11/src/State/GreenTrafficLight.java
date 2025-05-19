package State;

public class GreenTrafficLight implements ITrafficLightColor { // concrete state

    @Override
    public void change(TrafficLights lights) {
        lights.setColor(new YellowTrafficLight());
    }

    @Override
    public String get() {
        return "GREEN";
    }
}
