package Prototype;

public class Blog extends AbstractWebpage {

    public Blog(Integer id, String title, String content, String author, String[] tags,
                   String contentType, String creationDate, String modificationDate, Boolean isPublished,
                   String[] categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = new String[tags.length];
        for (Integer i = 0; i < tags.length; i++) {
            this.tags[i] = tags[i];
        }
        this.contentType = contentType;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.isPublished = isPublished;
        this.categories = new String[categories.length];
        for (Integer i = 0; i < categories.length; i++) {
            this.categories[i] = categories[i];
        }
    }

    @Override
    public void DisplayContentInfo() {
        System.out.println("----------------BLOG----------------");
        System.out.format("%-20s|%d\n", "ID", this.id);
        System.out.format("%-20s|%s\n", "Title", this.title);
        System.out.format("%-20s|%s\n", "Content", this.content);
        System.out.format("%-20s|%s\n", "Author", this.author);
        System.out.format("%-20s|", "Tags");
        for (Integer i = 0; i < this.tags.length; i++) {
            if (i == this.tags.length - 1) {
                System.out.println(this.tags[i]);
            }
            else {
                System.out.print(this.tags[i] + ", ");
            }
        }
        System.out.format("%-20s|%s\n", "Content Type", this.contentType);
        System.out.format("%-20s|%s\n", "Creation Date", this.creationDate);
        System.out.format("%-20s|%s\n", "Modification Date", this.modificationDate);
        System.out.format("%-20s|%s\n", "Is Published", this.isPublished ? "Yes" : "No");
        System.out.format("%-20s|", "Categories");
        for (Integer i = 0; i < this.categories.length; i++) {
            if (i == this.categories.length - 1) {
                System.out.println(this.categories[i]);
            }
            else {
                System.out.print(this.categories[i] + ", ");
            }
        }
    }

    @Override
    public boolean Publish() {
        String htmlContent = "<html>\n\t<head>\n\t\t<title>Blog</title>\n\t</head>"
                + "\n\t<body>\n\t\t<p>Hello World</p>\n\t</body>\n</html>";
        this.SetData(htmlContent.getBytes());
        Singleton.Controller.instance.Publish(this.id, this.htmlData);
        System.out.println("[*] Published blog with id " + this.id);
        return true;
    }

    @Override
    public boolean Unpublish() {
        this.htmlData = null;
        Singleton.Controller.instance.Unpublish(this.id);
        System.out.println("[*] Unpublished blog with id " + this.id);
        return true;
    }

    @Override
    public AbstractWebpage Clone() {
        Blog b = new Blog(this.id + 1, this.title, this.content, this.author, this.tags,
                this.contentType, this.creationDate, this.modificationDate, this.isPublished, this.categories);
        b.SetData(this.htmlData);
        return b;
    }
}
