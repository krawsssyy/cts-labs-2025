package Memento;
/*class to refactor -

public class Hero {
    private Integer health = 100;
    private Integer mana = 50;
    private Integer x = 0, y = 0;

    public void move(Integer dx, Integer dy) {
        this.x += dx;
        this.y += dy;
    }

    public void castSpell(Integer cost) {
        this.mana -= cost;
    }

    public void takeDamage(Integer damage) {
        this.health -= damage;
    }

    public Integer[] saveState() {
        return new Integer[] { this.health, this.mana, this.x, this.y };
    }

    public void loadState(Integer[] data) {
        this.health = data[0];
        this.mana = data[1];
        this.x = data[2];
        this.y = data[3];
    }

}*/
public class Hero { // the "originator" class
    // the given implementation breaks encapsulation since everyone can see our states
    // and also creates tight coupling for the loadState function, as one would have to know the exact order of the parameters to make it work correctly
    // we switch it around and use memento, as to keep our states safe
    // we generally use memento when we need undo/redo
    // or when our state is complex and exposing it/keeping a full copy somewhere outside would break some oop principles
    // we've seen that we can also do undo/redo with command, but that differs in the context
    // commands know enough to implement the undo themselves, whereas memento deals with states and doesn't know anything about the "originator"
    // it all depends on your use case
    // for example, memento is less memory efficient but more cpu efficient than command for undo/redo, but command is better for multi-objects as to avoid a "god" memento
    private Integer health = 100;
    private Integer mana = 50;
    private Integer x = 0, y = 0;

    public void move(Integer dx, Integer dy) {
        this.x += dx;
        this.y += dy;
    }

    public void castSpell(Integer cost) {
        this.mana -= cost;
    }

    public void takeDamage(Integer damage) {
        this.health -= damage;
    }

    public HeroMemento saveState() {
        return new HeroMemento(this.health, this.mana, this.x, this.y);
    }

    public void loadState(HeroMemento memento) {
        this.health = memento.getHealth();
        this.mana = memento.getMana();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    public Integer getHealth() {
        return this.health; // getter, so we can check it as an example
    }
}
