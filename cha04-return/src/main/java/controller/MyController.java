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
}
