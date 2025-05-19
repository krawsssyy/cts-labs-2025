package Flyweight;

import java.io.IOException;

public class GameObject {
    private Texture texture;
    private String type; // tree, building, unit, etc.
    private Position position;
    private Float rotation;
    private Integer health;
    private Boolean isAnimated;

    public GameObject(String filePath, Integer width, Integer height, String type, Integer x,
                      Integer y, Float rotation, Integer health, Boolean isAnimated) throws IOException {
        this.texture = TextureFactory.getTexture(filePath, width, height);
        this.type = type;
        this.position = new Position(x, y);
        this.rotation = rotation;
        this.health = health;
        this.isAnimated = isAnimated;
    }

    public void render() {
        System.out.println("Rendering game object:");
        System.out.println(this.texture.getFilePath() + "-" + this.texture.getWidth() + "-"
                + this.texture.getHeight() + "-" + this.type + "-" + this.position.getX() + "-"
                + this.position.getY() + "-" + this.rotation + "-" + this.health + "-" + this.isAnimated);
    }

    public void update() {
        this.health -= 1;
        System.out.println("Updated game object:");
        System.out.println(this.texture.getFilePath() + "-" + this.texture.getWidth() + "-"
                + this.texture.getHeight() + "-" + this.type + "-" + this.position.getX() + "-"
                + this.position.getY() + "-" + this.rotation + "-" + this.health + "-" + this.isAnimated);
    }

    public Float getRotation() {
        return this.rotation;
    }

    public Integer getHealth() {
        return this.health;
    }

    public Boolean getAnimated() {
        return this.isAnimated;
    }

}
