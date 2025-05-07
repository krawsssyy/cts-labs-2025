public class Screen {
    private Boolean isDown;

    public void up() {
        this.isDown = false;
        System.out.println("Screen raised up!");
    }

    public void down() {
        this.isDown = true;
        System.out.println("Screen pulled down!");
    }
}
