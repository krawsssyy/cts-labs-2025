package SimpleFactory;

import Prototype.AbstractGameObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SimpleFactory {

    public <T extends Prototype.AbstractGameObject> T CreateObject(Class<? extends Prototype.AbstractGameObject> object, Integer id, Integer positionX, Integer positionY, String textureFile, Boolean isVisible,
                                                                   Boolean isCollidable, Float scale, Float rotation, Integer width, Integer height,
                                                                   Integer health, Integer speed) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends AbstractGameObject> constructor = object.getConstructor(Integer.class, Integer.class, Integer.class, String.class,
                Boolean.class, Boolean.class, Float.class, Float.class,
                Integer.class, Integer.class, Integer.class, Integer.class);
        return (T)constructor.newInstance(id, positionX, positionY, textureFile, isVisible,
                isCollidable, scale, rotation, width, height, health,
                speed);
    }
}
