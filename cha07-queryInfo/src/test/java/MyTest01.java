import dao.ProvinceDao;
import entity.Province;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtils;

import java.util.List;

public class MyTest01 {
    @Test
    public void myTest01() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        List<Province> provinces = provinceDao.searchProvince(1);
        for (Province province : provinces) {
            System.out.println(province);
        }
    }
}
