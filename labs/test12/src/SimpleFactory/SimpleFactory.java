package SimpleFactory;

import Prototype.AbstractWebpage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SimpleFactory {

    public <T extends AbstractWebpage> T CreateObject(Class<? extends AbstractWebpage> object, Integer id, String title, String content, String author, String[] tags,
                                                      String contentType, String creationDate, String modificationDate, Boolean isPublished,
                                                      String[] categories) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends AbstractWebpage> constructor = object.getConstructor(Integer.class, String.class, String.class, String.class,
                String[].class, String.class, String.class, String.class,
                Boolean.class, String[].class);
        return (T)constructor.newInstance(id, title, content, author, tags,
                contentType, creationDate, modificationDate, isPublished, categories);
    }
}
