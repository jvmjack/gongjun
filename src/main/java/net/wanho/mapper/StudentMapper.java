package net.wanho.mapper;

import net.wanho.pojo.Student;

import java.util.List;


public interface StudentMapper {


    List<Student> getStu();

    void insertStudent(Student student);

    void deleteStudent(Integer id);

    Student getStuById(Integer id);

    void updateStudent(Student student);
}
