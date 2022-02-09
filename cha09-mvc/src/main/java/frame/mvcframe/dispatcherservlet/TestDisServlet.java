package frame.mvcframe.dispatcherservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 本类用来模仿mvc框架中的DispatcherServlet类，实现其功能
 * 逻辑：加载配置文件，扫描对应的类（注解），初始化bean对象（map实现ioc容器），依赖注入，构造一个map（url-method实现关联），等待请求
 */
public class TestDisServlet extends HttpServlet {
    private Properties properties = new Properties();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        String contextConfigLocation = config.getInitParameter("contextConfigLocation");
        doLoadConfig(contextConfigLocation);
    }

    //加载配置文件
    private void doLoadConfig(String contextConfigLocation) {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
