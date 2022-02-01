package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","welcome to springmvc");
        mav.addObject("fun","it is doSome");
        mav.setViewName("show.jsp");
        return mav;
    }
    @RequestMapping(value = "/other.do")
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","太哈人了");
        mv.addObject("fun","我先run了");
        mv.setViewName("other.jsp");
        return mv;
    }
}
