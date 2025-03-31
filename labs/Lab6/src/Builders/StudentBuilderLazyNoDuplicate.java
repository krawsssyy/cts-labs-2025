package Builders;

public class StudentBuilderLazyNoDuplicate { // another variant of the builder pattern
    // useful for not replicating parameters in the builder
    // simpler variant
    private String CNP;
    private String name;
    private Integer age;
    // optional
    private String faculty;

    private StudentBuilderLazyNoDuplicate() {
        // empty private constructor
        // we just need it to create our object in memory
    }

    public String getCNP() {
        return this.CNP;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getFaculty() {
        return this.faculty;
    }

    // for removing duplicating attributes inside the builder, we use private setters, that will be used inside the builder class
    private void setCNP(String CNP) {
        this.CNP = CNP;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static class StudentBuilderLazyNoDuplicateBuilder {
        private StudentBuilderLazyNoDuplicate student = null;

        public StudentBuilderLazyNoDuplicateBuilder(String CNP, String name, Integer age) {
            this.student = new StudentBuilderLazyNoDuplicate();
            this.student.setCNP(CNP);
            this.student.setName(name);
            this.student.setAge(age);
        }

        public StudentBuilderLazyNoDuplicateBuilder faculty(String faculty) {
            this.student.setFaculty(faculty);
            return this;
        }

        public StudentBuilderLazyNoDuplicate build() {
            return this.student;
        }
    }
}
