package models;

public class Lights {
    private Boolean isOn = false;

    public void turnOn() {
        if (this.isOn) {
            System.out.println("Lights already on!");
            return;
        }
        this.isOn = true;
        System.out.println("Lights on!");
    }

    public void turnOff() {
        if (!this.isOn) {
            System.out.println("Lights already off!");
            return;
        }
        this.isOn = false;
        System.out.println("Lights off!");
    }
}
