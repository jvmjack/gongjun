package net.wanho.service;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;

public interface StudentServiceI {

    PageInfo<Student> getStu(Integer pageNum);

    void insertStudent(Student student) ;

    void deleteStudent(Integer id);

    Student getStuById(Integer id);

    void updateStudent(Student student);
}
