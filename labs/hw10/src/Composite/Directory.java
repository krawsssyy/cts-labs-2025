package Composite;
import java.util.*;

public class Directory implements IFile {
    // composite structure, handles a group of elements just like one would be handled
    private String name;
    private ArrayList<IFile> files = new ArrayList<>();
    private IFile parent;

    public Directory(String name, IFile parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addFile(IFile file) {
        this.files.add(file);
    }

    @Override
    public Long getSize() {
        Long size = 0L;
        for (IFile file: this.files) {
            size += file.getSize();
        }
        return size;
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
