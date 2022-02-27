package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "returnString-view.do")
    public String returnStringView(HttpServletRequest request, String name, Integer age) {
        System.out.println("name = " + name+ ",age = " + age);
        request.setAttribute("myname",name + "deal");
        request.setAttribute("myage",age);
        return "some";
    }

    @RequestMapping(value = "returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response,String name, Integer age) throws IOException {
        System.out.println("name = " + name + ",age = " + age);
        Student student = new Student();
        student.setName("李四");
        student.setAge(22);
        String json = "";
        ObjectMapper om = new ObjectMapper();
        json = om.writeValueAsString(student);
        System.out.println("student转换的json=" + json);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }

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
