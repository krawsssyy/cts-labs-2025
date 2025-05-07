import Prototype.Enemy;
import Prototype.Obstacle;
import Prototype.Player;
import SimpleFactory.SimpleFactory;
import Singleton.GameEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        GameEngine instance1 = GameEngine.instance;
        GameEngine instance2 = GameEngine.instance;

        if (instance1 == instance2) {
            System.out.println("[*] Instances match!");
        }
        else {
            System.out.println("[*] Instances don't match! Critical error!");
            return;
        }
        SimpleFactory sf = new SimpleFactory();
        Player p1 = sf.CreateObject(Player.class, 0, 0, 0, "player.bin", true, true,
                1f, 0f, 20, 100, 100, 1);
        Enemy e1 = sf.CreateObject(Enemy.class, 1, 0, 0, "enemy.bin", true, true,
                1f, 0f, 20, 100, 100, 1);
        Obstacle o1 = sf.CreateObject(Obstacle.class, 2, 0, 0, "obstacle.bin", true, true,
                1f, 0f, 20, 100, 100, 1);
        System.out.println("[*] Created player 1 with id: " + p1.GetId());
        Player p2 = (Player)p1.Clone();
        Player p3 = (Player)p2.Clone();
        System.out.println("[*] Created player 3 with id: " + p3.GetId());
        Enemy e2 = (Enemy)e1.Clone();
        Enemy e3 = (Enemy)e2.Clone();
        Obstacle o2 = (Obstacle)o1.Clone();
        Obstacle o3 = (Obstacle)o2.Clone();

    }
}