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

//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        List<Brand> brandList= brandMapper.selectAll();
        System.out.println(brandList);

//        5. �ͷ���Դ
        sqlSession.close();

    }

    //ע�⿪��
    @Test
    public void testZhuJie() throws IOException {
        int id = 2;
//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

//        5. �ͷ���Դ
        sqlSession.close();
    }

    @Test//����id��ѯ����
    public void testSelectById() throws IOException {
        //
        int id = 2;


//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

//        5. �ͷ���Դ
        sqlSession.close();
    }

    @Test//��������ѯ��ɢװ������
    // �����������װ��brand
    // map���ϲ���
    public void testSelectByCondition() throws IOException {
        //���ղ���
        int status = 1;
        String companyName="��Ϊ";
        String brandName="��Ϊ";

        //�������
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //��װMap����
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);



//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        List<Brand> brandList = brandMapper.selectByCondition(status,companyName,brandName);
        System.out.println(brandList);

        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);

        List<Brand> brandMap = brandMapper.selectByCondition(map);
        System.out.println(brands);

//        5. �ͷ���Դ
        sqlSession.close();
    }


    @Test//��̬��ѯ
    public void testSelectByConditionDong() throws IOException {
        //���ղ���
        int status = 1;
        String companyName="С��";
        String brandName="С��";

        //�������
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //��װMap����


//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���

        //������
//        List<Brand> brands = brandMapper.selectByConditionDuo(brand);
//        System.out.println(brands);

        //������
        List<Brand> brands1 = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands1);
//        5. �ͷ���Դ
        sqlSession.close();
    }

    @Test//��Ӳ���
    public void testAdd() throws IOException {
        //���ղ���
        int status = 1;
        String companyName="xinghe";
        String brandName="xinghe";
        String description = "���ܴ���";
        int ordered = 300;

        //��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);//�Զ��ύ����

//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        brandMapper.add(brand);
        System.out.println(brand);
        /**
         * Setting autocommit to false on JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@67304a40]
         * �Զ��ύ�����ó�false
         * ���Գ���Rolling back JDBC Connection
         * openSession()Ĭ�Ͽ������񣬽�����ɾ�Ĳ��������Ҫʹ��sqlSession.commit()�ֶ��ύ����
         * sqlSessionFactory.openSession(true)��������Ϊ�Զ��ύ���񣨹ر�����
         * */
        //�ύ����
        sqlSession.commit();
//        5. �ͷ���Դ
        sqlSession.close();
    }


    @Test//��Ӳ��뷵��id
    public void testAddBackId() throws IOException {
        //���ղ���
        int status = 1;
        String companyName="�����ֻ�";
        String brandName="����";
        String description = "�����ֻ����ֻ��е�ս����";
        int ordered = 100;

        //��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//�Զ��ύ����

//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        brandMapper.addBackId(brand);

        Integer id = brand.getId();
        System.out.println(id);

//        5. �ͷ���Դ
        sqlSession.close();
    }


    @Test//�޸�
    public void testUpdate() throws IOException {
        //���ղ���
        int status = 0;
        String companyName="�����ֻ�";
        String brandName="����";
        String description = "�ֻ��е�ս����";
        int ordered = 100;

        int id = 9;

        //��װ����
        Brand brand = new Brand();
        brand.setId(id);
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);

//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//�Զ��ύ����

//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        brandMapper.update(brand);

        System.out.println(brand);

//        5. �ͷ���Դ
        sqlSession.close();
    }

    @Test//ɾ������
    public void testDeleteById() throws IOException {

        //���ղ���
        int status = 0;
        String companyName="�����ֻ�";
        String brandName="����";
        String description = "�ֻ��е�ս����";
        int ordered = 100;

        int id = 7;

        //��װ����
//        Brand brand = new Brand();
//        brand.setId(id);


//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//�Զ��ύ����

//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        brandMapper.deleteById(id);

//        5. �ͷ���Դ
        sqlSession.close();
    }


    @Test//ɾ������
    public void testDeleteByIds() throws IOException {
        //���ղ���
        int[]ids = {5,7};

        //��װ����
//        Brand brand = new Brand();
//        brand.setId(id);

//        1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2. ��ȡSqlSession����
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//�Զ��ύ����

//        3. ��ȡMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        4. ִ�з���
        brandMapper.deleteByIds(ids);

//        5. �ͷ���Դ
        sqlSession.close();
    }

}