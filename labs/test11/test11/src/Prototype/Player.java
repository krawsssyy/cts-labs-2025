package Prototype;

import java.io.*;

public class Player extends AbstractGameObject {

    public Player(Integer id, Integer positionX, Integer positionY, String textureFile, Boolean isVisible,
                  Boolean isCollidable, Float scale, Float rotation, Integer width, Integer height,
                  Integer health, Integer speed) throws IOException {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.textureFile = textureFile;
        this.isVisible = isVisible;
        this.isCollidable = isCollidable;
        this.scale = scale;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
        this.health = health;
        this.speed = speed;

        File fileIn = new File(this.textureFile);
        if (fileIn.isFile()) {
            FileInputStream fileInputStr = new FileInputStream(fileIn);
            DataInputStream dataInputStr = new DataInputStream(fileInputStr);

            this.textureData = dataInputStr.readAllBytes();

            dataInputStr.close();
            fileInputStr.close();
        }
    }
    @Override
    public void Update() {
        this.positionX += this.positionX * this.speed;
        this.positionY += this.positionY * this.speed;
        this.speed -= 1;
        this.health -= 1;
        Singleton.GameEngine.instance.ExecuteCommand("-update " + this.id + " -args \"{ positionX:" +
                this.positionX + ", positionY:" + this.positionY + ", speed:" + this.speed +
                ", health:" + this.health + "}\"");

        System.out.println("[*] Updated object with ID " + this.id);
    }

    @Override
    public void Render() {
        Singleton.GameEngine.instance.ExecuteCommand("-render " + this.id);
        System.out.println("[*] Rendered object with ID " + this.id);
    }

    @Override
    public void IsCollision(AbstractGameObject other) {
        if (this.positionX == other.getX() && this.positionY == other.getY()) {
            System.out.println("[*] Collision between two objects! Fixing..");
            this.Update();
            return;
        }

        System.out.println("[*] No collision found! Continuing...");
    }

    @Override
    public AbstractGameObject Clone() throws IOException {
        Player p = new Player(this.id + 1, this.positionX, this.positionY, "", this.isVisible,
                this.isCollidable, this.scale, this.rotation, this.width, this.height, this.health,
                this.speed); // leave textureFile empty to not create the textureData array
        p.SetData(this.textureData);
        return p;
    }
}
