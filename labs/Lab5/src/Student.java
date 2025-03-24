// Student.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    // required
    private final String id;
    private final String firstName;
    private final String lastName;
    // optional
    private final String email;
    private final Double gpa;
    private final LocalDate enrollmentDate;
    private final List<String> courses;

    // private constructor - to be used only by the builder and not by anyone else
    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.gpa = builder.gpa;
        this.enrollmentDate = builder.enrollmentDate;
        // immutable
        this.courses = Collections.unmodifiableList(new ArrayList<>(builder.courses));
    }

    // getters - no setters to maintain immutability
    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Double getGpa() {
        return this.gpa;
    }

    public LocalDate getEnrollmentDate() {
        return this.enrollmentDate;
    }

    public List<String> getCourses() {
        return this.courses; // already unmodifiable
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + this.id + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", gpa=" + this.gpa +
                ", enrollmentDate=" + this.enrollmentDate +
                ", courses=" + this.courses +
                '}';
    }

    // static inner builder class
    public static class StudentBuilder {
        // required attributes
        private final String id;
        private final String firstName;
        private final String lastName;

        // optional attributes with default values
        private String email = "";
        private Double gpa = 0.0;
        private LocalDate enrollmentDate = LocalDate.now();
        private final List<String> courses = new ArrayList<>();

        // constructor with only the required fields
        public StudentBuilder(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        // builder methods for optional attributes
        // returns this for chaining such as
        // StudentBuilder(**required_args).arg(arg_value).arg2(arg2_value)...
        public StudentBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder gpa(Double gpa) {
            this.gpa = gpa;
            return this;
        }

        public StudentBuilder enrollmentDate(LocalDate enrollmentDate) {
            this.enrollmentDate = enrollmentDate;
            return this;
        }

        public StudentBuilder addCourse(String course) {
            this.courses.add(course);
            return this;
        }

        public StudentBuilder addCourses(List<String> courses) {
            this.courses.addAll(courses);
            return this;
        }

        // final build method, the chain of building ends with this
        // StudentBuilder(**required_args).arg(arg_value).arg2(arg2_value).....build()
        // it creates the student object via usage of the private constructor
        public Student build() {
            // validations
            if (this.id == null || this.id.trim().isEmpty()) {
                throw new IllegalStateException("Student ID cannot be empty");
            }
            if (this.firstName == null || this.firstName.trim().isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (this.lastName == null || this.lastName.trim().isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }
            if (this.gpa < 0.0 || this.gpa > 4.0) {
                throw new IllegalStateException("GPA must be between 0.0 and 4.0");
            }

            // create the student object
            return new Student(this);
        }
    }
}