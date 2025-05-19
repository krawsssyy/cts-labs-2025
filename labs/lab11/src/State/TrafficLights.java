package State;

/*class TrafficLights {
    String state;
    public void change(), reportState();
}*/

public class TrafficLights { // the "context"
    private ITrafficLightColor color = new RedTrafficLight();

    public void change() { // different behavior depending on what the state is now
        this.color.change(this);
    }

    public void getState() {
        System.out.println(this.color.get());
    }

    public void setColor(ITrafficLightColor color) {
        this.color = color;
    }
}
