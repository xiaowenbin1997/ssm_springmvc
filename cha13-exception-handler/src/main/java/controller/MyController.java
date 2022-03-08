package controller;

import exception.AgeException;
import exception.MyException;
import exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping("some.do")
    public ModelAndView doSome(String name,Integer age) throws MyException {
        ModelAndView mv = new ModelAndView();
        if (!"zd".equals(name)) {
            throw new NameException("wrong name");
        }
        if (age == null || age > 60) {
            throw new AgeException("illegal age");
        }
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
}
