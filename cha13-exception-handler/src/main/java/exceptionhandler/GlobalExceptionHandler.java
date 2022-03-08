package exceptionhandler;

import exception.AgeException;
import exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NameException.class)
    public ModelAndView nameExceptionHandler(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","name is zd");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView ageExceptionHandler(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","age error");
        mv.addObject("ex",exception);
        mv.setViewName("ageError");
        return mv;
    }

    @ExceptionHandler
    public ModelAndView defaultExceptionHandler(Exception exception) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","default method");
        mv.addObject("ex",exception);
        mv.setViewName("defaultError");
        return mv;
    }
}
