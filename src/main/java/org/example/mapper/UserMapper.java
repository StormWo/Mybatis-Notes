package org.example.mapper;

import org.example.pojo.User;

import java.util.List;

/**
 * @Author: wyl
 * @Date: 2022/7/13
 * @Time: 15:45
 * @Description:
 */
public interface UserMapper {
    List<User> selectAll();
}
