package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/first.do",method = RequestMethod.GET)
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","典");
        mv.addObject("fun","run");
        mv.setViewName("some");
        return mv;
    }
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","蚌");
        mv.addObject("fun","埠");
        mv.setViewName("other");
        return mv;
    }
}
