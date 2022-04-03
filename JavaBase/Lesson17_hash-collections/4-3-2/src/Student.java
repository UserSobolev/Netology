import java.util.Objects;

public class Student {

    private final String name;
    private final String group;
    private final String studentId;

    public Student(String name, String group, String studentId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return name + ", " + group + ", " + studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.studentId);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Student student = (Student) object;
        return Objects.equals(studentId, student.studentId);
    }
}
