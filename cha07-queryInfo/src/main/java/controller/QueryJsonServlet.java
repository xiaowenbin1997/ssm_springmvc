package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import entity.Province;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        String proId = request.getParameter("proid");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        if (proId != null && proId.trim().length() > 0) {
            Province province = provinceDao.searchProvince(Integer.parseInt(proId));
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(province);
        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
