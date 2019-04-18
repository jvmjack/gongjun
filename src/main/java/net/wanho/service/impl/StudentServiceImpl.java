package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceI {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public PageInfo<Student> getStu(Integer pageNum) {
//        设置分页信息
        PageHelper.startPage(pageNum, 4);
        List<Student> list = studentMapper.getStu();
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    @Override
    public Student getStuById(Integer id) {
        return studentMapper.getStuById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }


}
