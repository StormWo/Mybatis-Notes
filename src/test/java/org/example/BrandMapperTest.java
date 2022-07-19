package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wyl
 * @Date: 2022/7/18
 * @Time: 9:38
 * @Description:
 */

public class BrandMapperTest {
    @Test
    public void testSelectAll() throws IOException {

//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        List<Brand> brandList= brandMapper.selectAll();
        System.out.println(brandList);

//        5. 释放资源
        sqlSession.close();

    }

    //注解开发
    @Test
    public void testZhuJie() throws IOException {
        int id = 2;
//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

//        5. 释放资源
        sqlSession.close();
    }

    @Test//根据id查询详情
    public void testSelectById() throws IOException {
        //
        int id = 2;


//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

//        5. 释放资源
        sqlSession.close();
    }

    @Test//多条件查询，散装参数，
    // 对象参数，封装进brand
    // map集合参数
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //封装Map集合
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);



//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        List<Brand> brandList = brandMapper.selectByCondition(status,companyName,brandName);
        System.out.println(brandList);

        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);

        List<Brand> brandMap = brandMapper.selectByCondition(map);
        System.out.println(brands);

//        5. 释放资源
        sqlSession.close();
    }


    @Test//动态查询
    public void testSelectByConditionDong() throws IOException {
        //接收参数
        int status = 1;
        String companyName="小米";
        String brandName="小米";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //封装Map集合


//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法

        //多条件
//        List<Brand> brands = brandMapper.selectByConditionDuo(brand);
//        System.out.println(brands);

        //单条件
        List<Brand> brands1 = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands1);
//        5. 释放资源
        sqlSession.close();
    }

    @Test//添加插入
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName="xinghe";
        String brandName="xinghe";
        String description = "智能创造";
        int ordered = 300;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        brandMapper.add(brand);
        System.out.println(brand);
        /**
         * Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@67304a40]
         * 自动提交被设置成false
         * 所以出现Rolling back JDBC Connection
         * openSession()默认开启事务，进行增删改查操作后需要使用sqlSession.commit()手动提交事务
         * sqlSessionFactory.openSession(true)可以设置为自动提交事务（关闭事务）
         * */
        //提交事务
        sqlSession.commit();
//        5. 释放资源
        sqlSession.close();
    }


    @Test//添加插入返回id
    public void testAddBackId() throws IOException {
        //接收参数
        int status = 1;
        String companyName="波导手机";
        String brandName="波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        brandMapper.addBackId(brand);

        Integer id = brand.getId();
        System.out.println(id);

//        5. 释放资源
        sqlSession.close();
    }


    @Test//修改
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName="波导手机";
        String brandName="波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        int id = 9;

        //封装对象
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);

//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        brandMapper.update(brand);

        System.out.println(brand);

//        5. 释放资源
        sqlSession.close();
    }

    @Test//删除单行
    public void testDeleteById() throws IOException {

        //接收参数
        int status = 0;
        String companyName="波导手机";
        String brandName="波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        int id = 7;

        //封装对象
//        Brand brand = new Brand();
//        brand.setId(id);


//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        brandMapper.deleteById(id);

//        5. 释放资源
        sqlSession.close();
    }


    @Test//删除批量
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[]ids = {5,7};

        //封装对象
//        Brand brand = new Brand();
//        brand.setId(id);

//        1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. 获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动提交事务

//        3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. 执行方法
        brandMapper.deleteByIds(ids);

//        5. 释放资源
        sqlSession.close();
    }

}