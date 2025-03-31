package Builders;

public class StudentBuilderEager { // another variant of the builder pattern
    // simpler variant and more straight-forward
    // similar to the no duplicates variant, but in this case the inner class is no longer an inner class, but a class of its own
    // makes use of the default access modifier in java, which is private-package
    // private is more restrictive, but private-package means that attributes are restricted only to the current package
    private String CNP;
    private String name;
    private Integer age;
    // optional
    private String faculty;

    // no access modifier
    StudentBuilderEager() {
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

    // no acces modifiers for the setters, such that they are private-package and can be used from a different class altogether
    void setCNP(String CNP) {
        this.CNP = CNP;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(Integer age) {
        this.age = age;
    }

    void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
