package mthree.com.fullstackschool.model;

import java.util.Objects;

public class Student {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;

    public int getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return studentId == student.studentId && Objects.equals(studentFirstName, student.studentFirstName) && Objects.equals(studentLastName, student.studentLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentFirstName, studentLastName);
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

}

