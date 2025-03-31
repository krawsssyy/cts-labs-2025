package Prototypes;
import java.util.*;
import java.io.*;
public abstract class ScenePrototype implements Cloneable {
    // prototype is a design pattern used to help in resource-heavy applications
    // it is used to provide an interface for easily cloning objects rather than initializing them
    // when cloning is cheaper than initializing

    // another variant of this exists, PrototypeRegistry/PrototypeFactory, where we'd use a similar strategy
    // to the SingletonRegistry
    // specifically, we'd have internally a HashMap<String, ScenePrototype>, and just keep track of each
    // instead of cloning, we'd just get the value from the hashmap
    protected List<String> bitmaps;
    protected String configFile;
    protected List<String> characters;

    public ScenePrototype(String configFile) {
        this.configFile = configFile;
        // very resource extensive part
        this.loadBitmapsFromConfig();
        this.loadCharactersFromConfig();
        this.initializeBitmaps();
        this.initializeCharacters();
    }

    public ScenePrototype(List<String> bitmaps, String configFile, List<String> characters) {
        this.configFile = configFile;
        this.bitmaps = new ArrayList<>(bitmaps);
        this.characters = new ArrayList<>(characters);
        this.initializeBitmaps();
        this.initializeCharacters();
    }

    protected void loadBitmapsFromConfig() {
        // simulate loading bitmap paths from the config
    }

    protected void loadCharactersFromConfig() {
        // simulate loading characters paths from the config
    }

    protected void initializeBitmaps() {
        // simulate actually loading the binary data of the bitmaps and processing it
        // into other internal variables and memory
    }

    protected void initializeCharacters() {
        // simulate actually loading the binary data of the characters and processing it
        // into other internal variables and memory
    }

    abstract void draw(List<Integer> x, List<Integer> u, List<Integer> z); // draw the scene - it is up to the concrete implementation to do

    @Override
    public Object clone() {
        // a simple shallow-copy, just for example
        // in practice, we'd use deep copy for this case (depends on the usage case)
        // for deep copies, use serialization + deserialization or a copy constructor
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
