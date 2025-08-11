package Dao;

import model.Student;

import java.util.List;

public interface StudentDao {
    public abstract boolean createStudent(String name,int age);
    public abstract Student getStudentById(int id);
    public abstract boolean updateStudent(int id, String name,int age);
    public abstract boolean deleteStudent(int id);
    public abstract List<Student> getAllStudent();
}
