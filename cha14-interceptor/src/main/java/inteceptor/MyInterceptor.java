package inteceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class MyInterceptor implements HandlerInterceptor {
    long beginTime = 0;
    long endTime = 0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        beginTime = System.currentTimeMillis();
        System.out.println("preHandler");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handler");
        if (modelAndView != null) {
            modelAndView.addObject("mydate",new Date());
            modelAndView.setViewName("other");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after Completion");
        endTime = System.currentTimeMillis();
        System.out.println("last time is " + (endTime - beginTime));
    }
}
