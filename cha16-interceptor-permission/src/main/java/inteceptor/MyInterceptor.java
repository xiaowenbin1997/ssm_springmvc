package inteceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler01");
        String loginName = "";
        Object nameStr = request.getSession().getAttribute("name");
        if (nameStr != null) {
            loginName = (String) nameStr;
        }
        if (!"zs".equals(loginName)) {
            request.getRequestDispatcher("tips.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
