public class Lights {
    public Integer brightness = 50;

    public void brighten() {
        if (this.brightness == 100) {
            System.out.println("Cannot brigthen the lights any more!");
            return;
        }
        this.brightness += 10;
        System.out.println("Brightened the lights by 10!");
    }

    public void dim() {
        if (this.brightness == 0) {
            System.out.println("Cannot dim the lights any more!");
            return;
        }
        this.brightness -= 10;
        System.out.println("Dimmed the lights by 10!");
    }
}
