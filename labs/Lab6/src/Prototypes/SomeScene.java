package Prototypes;

import java.util.List;

public class SomeScene extends ScenePrototype {

    public SomeScene(String configFile) {
        super(configFile);
        System.out.println("Initialized SomeScene!");
    }

    @Override
    void draw(List<Integer> x, List<Integer> y, List<Integer> z) {
        System.out.println("Drawing SomeScene!");
        // drawing logic
    }
}

// now, in main, we might have
// SomeScene s = new SomeScene("config.ini");
// now, if this scene appears multiple times, we can just skip the reinitialization part and just get a clone to it and in multiple places
// e.g. some far away places the user can't reach and the scenery is the same
// so we do
// SomeScene s1 = s.clone();
// SomeScene s2 = s.clone();
// s.draw({1,2,3,4}, {1,2,3,4}, {1,2,3,4});
// s1.draw({10,11,12,13},{10,11,12,13},{10,11,12,13});
// s2.draw({6,7,8,9},{6,7,8,9},{6,7,8,9});
// so, we have essentially drawn the scene in three different places, and skipped the initialization part by cloning
