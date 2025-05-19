import Composite.*;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("C:\\", null);
        Directory usr = new Directory("Users", root);
        File desktop = new File("desktop.ini", 11L, "Hello World".getBytes(), usr);
        File desktop2 = new File("desktop2.ini", 4L, "test".getBytes(), usr);
        usr.addFile(desktop);
        usr.addFile(desktop2);
        System.out.println(desktop.getParent().getName());
        System.out.println(usr.getSize());
    }
}
