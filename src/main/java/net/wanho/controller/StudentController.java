package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import net.wanho.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceI studentServiceI;

     @RequestMapping("getStu")
//    @ResponseBody
    public String getSatu(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Map map){
        PageInfo<Student> pageInfo = studentServiceI.getStu(pageNum);
/*        JsonResult result=new JsonResult();
        result.setStatus(200);
        result.setMsg("查询成功");
        result.setData(pageInfo);
        return result;*/
        map.put("pageInfo",pageInfo);
        return "showStudent";
    }
    /*跳转页面*/
    @RequestMapping("addStu")
    public String toAddStudent(){
         return "addStudent";
    }

    @RequestMapping("insertStudent")
    @ResponseBody
    public String insertStudent(Student student){
        JSONObject jsonObject = new JSONObject();
        studentServiceI.insertStudent(student);
        return jsonObject.toString();
    }


    @RequestMapping("deleteStudent")
    public String  deleteStudent(Integer id){
        studentServiceI.deleteStudent(id);
        return "redirect:/getStu";
    }

    @RequestMapping("getStuById")
    public String getStuById(Integer id,Map map){
        Student student = studentServiceI.getStuById(id);
       /* JsonResult result=new JsonResult();*/
        map.put("student",student);
        return "updateStudent";
    }

    @RequestMapping("updateStudent")
    @ResponseBody
    public String updateStudent( Student student){
        JSONObject jsonObject = new JSONObject();
        studentServiceI.updateStudent(student);
        return jsonObject.toString();
    }











/*    @RequestMapping("insertStu")
    @ResponseBody
    public JsonResult insertStu(Student student){
        JsonResult result=new JsonResult();
        Student student1=new Student(null,"阿旺",18,"male","南京");
        studentServiceI.insert(student1);
        result.setStatus(200);
        result.setMsg("新增成功");
        return result;
    }*/


}


/*    @RequestMapping("getStu")
    @ResponseBody
    public JsonResult getSatu(){
        List<Student> students=studentServiceI.getStu();
        JsonResult result=new JsonResult();
        result.setStatus(200);
        result.setMsg("查询成功");
        result.setData(students);
        return result;
    }*/
