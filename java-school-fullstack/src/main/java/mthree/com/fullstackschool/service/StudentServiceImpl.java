package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.StudentDao;
import mthree.com.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    //YOUR CODE STARTS HERE
    @Autowired
    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    //YOUR CODE ENDS HERE

    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE
        try {
            return studentDao.getAllStudents();
        } catch (DataAccessException e) {
            System.out.println("Error fetching all students: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Student getStudentById(int id) {
        //YOUR CODE STARTS HERE
        try {
            return studentDao.findStudentById(id);
        } catch (DataAccessException e) {
            System.out.println("Error fetching student by id: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Student addNewStudent(Student student) {
        //YOUR CODE STARTS HERE
        try {
            return studentDao.createNewStudent(student);
        } catch (DataAccessException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Student updateStudentData(int id, Student student) {
        //YOUR CODE STARTS HERE

        if (student.getStudentId() != id) {
            System.out.println("IDs do not match, student not updated");
            student.setStudentFirstName("IDs do not match, student not updated");
            student.setStudentLastName("IDs do not match, student not updated");
            return null; // or return the same student unchanged
        }
        if(student.getStudentId()==id) {
            try {
                student.setStudentId(id);
                studentDao.updateStudent(student);
                return student;
            } catch (DataAccessException e) {
                System.out.println("Error updating student: " + e.getMessage());
                return null;
            }
        }
        return null;
        //YOUR CODE ENDS HERE
    }

    public void deleteStudentById(int id) {
        //YOUR CODE STARTS HERE
        try {
            studentDao.deleteStudent(id);
        } catch (DataAccessException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
        //YOUR CODE ENDS HERE
    }

    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
        try {
            studentDao.deleteStudentFromCourse(studentId, courseId);
        } catch (DataAccessException e) {
            System.out.println("Error removing student from course: " + e.getMessage());
        }
        //YOUR CODE ENDS HERE
    }

    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
        try {
            studentDao.addStudentToCourse(studentId, courseId);
        } catch (DataAccessException e) {
            System.out.println("Error adding student to course: " + e.getMessage());
        }
        //YOUR CODE ENDS HERE
    }
}
