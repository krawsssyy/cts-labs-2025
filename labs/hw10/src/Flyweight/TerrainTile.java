package Flyweight;

import java.io.IOException;

public class TerrainTile {
    private Texture texture; // intrinsic state - to be shared
    private String type; // grass, water, sand, etc.
    private Position position;
    private Boolean isWalkable;
    private Integer movementCost;

    public TerrainTile(String filePath, Integer width, Integer height, String type, Integer x,
                       Integer y, Boolean isWalkable, Integer movementCost) throws IOException {
        this.texture = TextureFactory.getTexture(filePath, width, height);
        this.type = type;
        this.position = new Position(x, y);
        this.isWalkable = isWalkable;
        this.movementCost = movementCost;
    }
    public void render() {
        System.out.println("Rendering a terrain tile:");
        System.out.println(this.texture.getFilePath() + "-" + this.texture.getWidth() + "-" +
                this.texture.getHeight() + "-" + this.type + "-" + this.position.getX() + "-" +
                this.position.getY() + "-" + this.isWalkable + "-" + this.movementCost);
    }

    public String getType() {
        return this.type;
    }

    public Boolean getWalkable() {
        return this.isWalkable;
    }

    public Integer getMovementCost() {
        return this.movementCost;
    }
}
