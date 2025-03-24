public class Main {
    public static void main(String[] args) {
        Student student1 = new Student.StudentBuilder("S001", "John", "Doe")
                .build();
        System.out.println("Student 1: " + student1);

        Logger logger = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        if (logger == logger2) {
            System.out.println("Logger instances are the same!");
        }
        else {
            System.out.println("Logger instances differ!");
        }
    }
}