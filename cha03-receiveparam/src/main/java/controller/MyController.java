package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/receiveproperty.do",method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age) {
        System.out.println("name =" + name + "age = " + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname","典" + name);
        mv.addObject("myage","run" + age);
        mv.setViewName("some");
        return mv;
    }
    @RequestMapping(value = "/receiveparam.do",method = RequestMethod.POST)
    public ModelAndView doOther(@RequestParam(value = "rname") String name,
                                @RequestParam(value = "rage") Integer age) {
        System.out.println("rname = " + name + "rage = " + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","蚌" + name);
        mv.addObject("fun","埠" + age);
        mv.setViewName("other");
        return mv;
    }

    @RequestMapping(value = "/receiveobject.do",method = RequestMethod.POST)
    public ModelAndView testObjectParam(Student student) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.addObject("mystudent",student);
        mv.setViewName("some");
        return mv;
    }
}
