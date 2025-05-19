package Composite;

public class File implements IFile {
    // leaf class
    private String name;
    private Long size;
    private byte[] content;
    private IFile parent;

    public File(String name, Long size, byte[] content, IFile parent) {
        this.name = name;
        this.size = size;
        this.parent = parent;
        this.content = new byte[content.length];
        System.arraycopy(content, 0, this.content, 0, content.length);
    }

    @Override
    public Long getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

    @Override
    public IFile getParent() {
        return this.parent;
    }
}
