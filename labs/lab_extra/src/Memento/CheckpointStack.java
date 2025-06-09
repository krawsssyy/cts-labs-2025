package Memento;
import java.util.*;
public class CheckpointStack {
    // the "caretaker" class
    // it holds a list (or stack, or queue, whatever you see fit for your usecase) of the states of an application
    // it can't access the states, and is only used in
    private Stack<HeroMemento> history = new Stack<>();

    public void addCheckpoint(HeroMemento memento) {
        this.history.push(memento);
    }

    public HeroMemento restoreCheckpoint() {
        return this.history.pop();
    }
}
