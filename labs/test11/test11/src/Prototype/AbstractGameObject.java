package Prototype;

import java.io.IOException;

public abstract class AbstractGameObject {
    protected Integer id;
    protected Integer positionX;
    protected Integer positionY;
    protected String textureFile;
    protected Boolean isVisible;
    protected Boolean isCollidable;
    protected Float scale;
    protected Float rotation;
    protected Integer width;
    protected Integer height;
    protected Integer health;
    protected Integer speed;
    protected byte[] textureData; // to be populated with data by the constructor

    // updates the object's state based on game logic
    // perform simple updates based on various attributes (that make sense), then send a command to the engine
    // logs to the screen that an update is happening
    // command format: -update <ObjectID> -args "{<ModifiedArg1>:<NewValueArg1>, ..., <ModifiedArgN>:<NewValueArgN>}"
    public abstract void Update();

    // renders the object on screen
    // mock it with a simple print to the screen
    // send a command to the engine
    // command format: -render <ObjectID>
    public abstract void Render();

    // checks for a potential collision with another object
    // perform simple checks and updates on the attributes to fix a collision (if it is), then call `this.Update();`
    // logs to the screen the appropriate response (no collision/collision fixed)
    public abstract void IsCollision(AbstractGameObject other);

    public Integer GetId() {
        return this.id;
    }

    public void SetId(Integer id) {
        this.id = id;
    }

    public void SetPosition(Integer x, Integer y) {
        this.positionX = x;
        this.positionY = y;
    }

    public Boolean IsVisible() {
        return this.isVisible;
    }

    public void SetVisible(Boolean visible) {
        this.isVisible = visible;
    }

    public Boolean IsCollidable() {
        return this.isCollidable;
    }

    public void SetCollidable(Boolean collidable) {
        this.isCollidable = collidable;
    }

    public Integer getX() {
        return this.positionX;
    }

    public Integer getY() {
        return this.positionY;
    }

    public void SetData(byte[] textureData) {
        if (textureData != null) {
            this.textureData = new byte[textureData.length];
            System.arraycopy(this.textureData, 0, textureData, 0, textureData.length);
        }
    }

    // perform a deep copy of the object
    public abstract AbstractGameObject Clone() throws IOException;
}
