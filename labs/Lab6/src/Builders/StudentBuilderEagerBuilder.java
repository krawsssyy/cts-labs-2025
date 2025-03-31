package Builders;

public class StudentBuilderEagerBuilder { // builder class for StudentBuilderEager
    // exactly the same builder as in the no duplicates version
    // in this case, the builder is a separate entity

    private StudentBuilderEager student = null;

    public StudentBuilderEagerBuilder(String CNP, String name, Integer age) {
        this.student = new StudentBuilderEager();
        this.student.setCNP(CNP);
        this.student.setName(name);
        this.student.setAge(age);
    }

    public StudentBuilderEagerBuilder faculty(String faculty) {
        this.student.setFaculty(faculty);
        return this;
    }

    public StudentBuilderEager build() {
        return this.student;
    }


}
