package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping("doForward.do")
    public ModelAndView doSome() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","滴滴");
        mv.addObject("fun","拉拉");
        mv.setViewName("forward:/test.jsp");
        return mv;
    }
    @RequestMapping("doRedirect.do")
    public ModelAndView doRedirect() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "1");
        mv.addObject("fun", "1");
        mv.setViewName("redirect:/test1.jsp");
        return mv;
    }
}
