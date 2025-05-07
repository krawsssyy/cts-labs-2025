import Prototype.Article;
import Prototype.Blog;
import Prototype.Forum;
import SimpleFactory.SimpleFactory;
import Singleton.Controller;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] tags = { "tag1", "tag2" };
        String[] categories = { "cat1", "cat2"};
        Controller instance1 = Controller.instance;
        Controller instance2 = Controller.instance;

        if (instance1 == instance2) {
            System.out.println("[*] Instances match!");
        }
        else {
            System.out.println("[*] Instances don't match! Critical error!");
            return;
        }

        SimpleFactory sf = new SimpleFactory();
        Article a1 = sf.CreateObject(Article.class, 0, "article1", "nice article", "alex", tags, "article",
                "2025-01-04", "2025-03-12", true, categories);
        Forum f1 = sf.CreateObject(Forum.class, 0, "forum1", "nice forum", "alex", tags, "forum",
                "2025-01-04", "2025-03-12", true, categories);
        Blog b1 = sf.CreateObject(Blog.class, 0, "blog1", "nice blog", "alex", tags, "blog",
                "2025-01-04", "2025-03-12", true, categories);
        System.out.println("[*] Created article 1 with id: " + a1.GetId());
        Article a2 = (Article)a1.Clone();
        Article a3 = (Article)a2.Clone();
        System.out.println("[*] Created article 3 with id: " + a3.GetId());
        Forum f2 = (Forum)f1.Clone();
        Forum f3 = (Forum)f2.Clone();
        Blog b2 = (Blog)b1.Clone();
        Blog b3 = (Blog)b2.Clone();
        b3.DisplayContentInfo();
        f2.Publish();
        a3.Unpublish();
    }
}
