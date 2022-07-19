package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.pojo.User;
import org.example.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: wyl
 * @Date: ${DATE}
 * @Time: ${TIME}
 * @Description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        inputStream = Resources.getResourceAsStream(resource);

        System.out.println(inputStream);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SQL session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
//        List<Object> users = sqlSession.selectList("test.selectAll");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users= userMapper.selectAll();

        System.out.println(users);

        sqlSession.close();


    }


}