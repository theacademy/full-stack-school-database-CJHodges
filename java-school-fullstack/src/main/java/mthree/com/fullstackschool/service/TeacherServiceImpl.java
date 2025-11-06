package mthree.com.fullstackschool.service;

import mthree.com.fullstackschool.dao.CourseDao;
import mthree.com.fullstackschool.dao.TeacherDao;
import mthree.com.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    @Autowired
    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    //YOUR CODE STARTS HERE
    @Autowired
    private TeacherDao teacherDao;
    //YOUR CODE ENDS HERE

    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE
        try {
            return teacherDao.getAllTeachers();
        } catch (DataAccessException e) {
            System.out.println("Error fetching all teachers: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Teacher getTeacherById(int id) {
        //YOUR CODE STARTS HERE
        try {
            return teacherDao.findTeacherById(id);
        } catch (DataAccessException e) {
            System.out.println("Error fetching teacher by id: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Teacher addNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE
        try {
            return teacherDao.createNewTeacher(teacher);
        } catch (DataAccessException e) {
            System.out.println("Error adding teacher: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {
        //YOUR CODE STARTS HERE

        if(id != teacher.getTeacherId()){
            teacher.setTeacherFName("IDs do not match, teacher not updated");
            teacher.setTeacherLName("IDs do not match, teacher not updated");
            return null;
        }


        try {
            teacher.setTeacherId(id);
            teacherDao.updateTeacher(teacher);
            return teacher;
        } catch (DataAccessException e) {
            System.out.println("Error updating teacher: " + e.getMessage());
            return null;
        }
        //YOUR CODE ENDS HERE
    }

    public void deleteTeacherById(int id) {
        //YOUR CODE STARTS HERE
        try {
            teacherDao.deleteTeacher(id);
        } catch (DataAccessException e) {
            System.out.println("Error deleting teacher: " + e.getMessage());
        }
        //YOUR CODE ENDS HERE
    }
}
