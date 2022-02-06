import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BmiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String weight = request.getParameter("w");
        String height = request.getParameter("h");

        double w = Double.valueOf(weight);
        double h = Double.valueOf(height);
        double bmi = w / (h * h);
        String msg = "";
        if (bmi <= 18.5) {
            msg = "瘦";
        } else {
            msg = "不瘦";
        }
        System.out.println("msg=" + msg);
        msg = "您好：" + name + ",您的bmi值是" + bmi;
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
