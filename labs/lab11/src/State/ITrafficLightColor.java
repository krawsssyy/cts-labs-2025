package State;

public interface ITrafficLightColor { // state interface
    public void change(TrafficLights lights);
    public String get();
}
