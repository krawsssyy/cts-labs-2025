package Flyweight;
import java.io.IOException;
import java.util.*;

public class GameMap {
    private Integer width;
    private Integer height;
    private TerrainTile[][] terrainTiles;
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public GameMap(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    private void initializeMap() throws IOException {
        for (Integer i = 0; i < width; i++) {
            for (Integer j = 0; j < height; j++) {
                String textureType;
                Boolean isWalkable;
                Integer movementCost;
                String texturePath;
                Integer w, h;
                if ((i + j) % 5 == 0) { // some simple random logic for initializing the map
                    textureType = "water";
                    isWalkable = false;
                    movementCost = 100;
                    texturePath = "water.bin";
                    w = h = 10;
                }
                else {
                    textureType = "grass";
                    isWalkable = true;
                    movementCost = 0;
                    texturePath = "grass.bin";
                    w = h = 50;
                }
                this.terrainTiles[i][j] = new TerrainTile(texturePath, w, h, textureType,
                        i, j, isWalkable, movementCost);
                this.terrainTiles[i][j].render();
            }
        }
    }

    public void addGameObject(String filePath, Integer width, Integer height, String type,
                              Integer x, Integer y, Float rotation, Integer health,
                              Boolean isAnimated) throws IOException {
        GameObject obj = GameObjectFactory.getGameObject(filePath, width, height, type, x, y,
                rotation, health, isAnimated); // flyweight-ish for game objects, just to save some space
        // but doesn't use any extrinsic states
        this.gameObjects.add(obj);
    }

    public void renderFrame() {
        for (GameObject obj: this.gameObjects) {
            obj.render();
        }
    }

    public void updateFrame() {
        for (GameObject obj: this.gameObjects) {
            obj.update();
        }
    }
}
