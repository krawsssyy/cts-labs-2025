package Prototype;

public abstract class AbstractWebpage {
    protected Integer id;
    protected String title;
    protected String content;
    protected String author;
    protected String[] tags;
    protected String contentType;
    protected String creationDate;
    protected String modificationDate;
    protected Boolean isPublished;
    protected String[] categories;
    protected byte[] htmlData;

    // nice, tabled (formatted) output for the details of the webpage
    public abstract void DisplayContentInfo();

    // populates the `htmlData` array with data used within the webpage (whatever format you'd like)
    // calls `Publish` from the Controller with the necessary data
    // logs the action to the console
    public abstract boolean Publish();

    // clears the byte array and logs the action
    // calls `Unpublish` from the Controller
    public abstract boolean Unpublish();


    public Integer GetId() {
        return this.id;
    }

    public String GetTitle() {
        return this.title;
    }

    public void SetTitle(String title) {
        this.title = title;
    }

    public String GetContent() {
        return this.content;
    }

    public void SetContent(String content) {
        this.content = content;
    }

    public boolean IsPublished() {
        return this.isPublished;
    }

    public void SetData(byte[] htmlData) {
        if (htmlData != null) {
            this.htmlData = new byte[htmlData.length];
            System.arraycopy(this.htmlData, 0, htmlData, 0, htmlData.length);
        }
    }

    // creates a deep copy of the object
    public abstract AbstractWebpage Clone();
}