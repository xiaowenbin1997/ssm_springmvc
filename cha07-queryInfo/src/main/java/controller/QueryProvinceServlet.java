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
import java.util.List;

public class QueryProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId = request.getParameter("proid");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        String province = "";
        if (proId != null && proId.trim().length() > 0) {
            province = provinceDao.searchProName(Integer.parseInt(proId));
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(province);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
