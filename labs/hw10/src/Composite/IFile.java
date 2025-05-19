package Composite;

public interface IFile {
    public Long getSize();
    public String getName();
    public void rename(String name);
    public IFile getParent();
}
