package Memento;

public class HeroMemento {
    // class that will serve as the current state of the hero, at the moment of saving
    // the "memento" class
    private final Integer health, mana, x, y;

    public HeroMemento(Integer health, Integer mana, Integer x, Integer y) {
        this.health = health;
        this.mana = mana;
        this.x = x;
        this.y = y;
    } // ideally, this should be package-private as to maintain encapsulation, but sometimes it might work as such as well

    public Integer getHealth() {
        return this.health;
    }

    public Integer getMana() {
        return this.mana;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}
