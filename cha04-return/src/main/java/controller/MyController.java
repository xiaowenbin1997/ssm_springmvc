package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping("returnStudentJson.do")
    @ResponseBody
    public Student returnStudentJson(String name,Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }
    @RequestMapping("returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> returnJsonArray() {
        List<Student> studentList = new ArrayList<>();
        Student student01 = new Student();
        student01.setName("张三");
        student01.setAge(11);
        studentList.add(student01);
        Student student02 = new Student();
        student02.setName("李四");
        student02.setAge(15);
        studentList.add(student02);
        return studentList;
    }

    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody//不是返回视图名，而是返回字符串对象
    public String returnStringData(String name,Integer age) {
        return "hello springmvc 返回字符串";
    }
}
