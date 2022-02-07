package dao;

import entity.Province;

import java.util.List;

public interface ProvinceDao {
    public Province searchProvince(Integer id);
    public String searchProName(Integer id);
}
