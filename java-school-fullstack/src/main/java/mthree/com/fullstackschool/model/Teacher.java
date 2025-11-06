package mthree.com.fullstackschool.model;

import java.util.Objects;

public class Teacher {
    private int teacherId;
    private String teacherFName;
    private String teacherLName;
    private String dept;

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Teacher teacher)) return false;
        return teacherId == teacher.teacherId && Objects.equals(teacherFName, teacher.teacherFName) && Objects.equals(teacherLName, teacher.teacherLName) && Objects.equals(dept, teacher.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherFName, teacherLName, dept);
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFName() {
        return teacherFName;
    }

    public void setTeacherFName(String teacherFName) {
        this.teacherFName = teacherFName;
    }

    public String getTeacherLName() {
        return teacherLName;
    }

    public void setTeacherLName(String teacherLName) {
        this.teacherLName = teacherLName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
