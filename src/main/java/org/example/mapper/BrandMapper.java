package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * @Author: wyl
 * @Date: 2022/7/13
 * @Time: 15:40
 * @Description:
 */
public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();

    //注解开发
    @Select("select *from tb_brand where id=#{id}")
    Brand selectZhuJie(int id);

    //查看详情：根据id值
    Brand selectById(int id);

    /**
     * 多条件查询
     * 1.散装参数：方法中有多个参数，需要使用Param(SQL参数占位符名称)
     * 2.对象参数：
     * 3.map集合参数
    */

    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    //多条件动态查询
    List<Brand> selectByConditionDuo(Brand brand);

    //单条件动态查询，从多个条件中选择一个
    List<Brand> selectByConditionSingle(Brand brand);

    //增加插入
    void add(Brand brand);

    //添加，返回id
    void addBackId(Brand brand);

    //修改
    int update(Brand brand);

    //删除单行
    void deleteById(int id);
    //批量删除
    void deleteByIds(int ids[]);



}
