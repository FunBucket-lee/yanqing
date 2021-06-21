package com.qing.dao;

import com.qing.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //获取全部用户
    List<User> getUserList();

    //分页查询
    List<User> getUser(Map<String,Integer> map);

    //更具用户ID查询
    User getUserByID(int id);

    //使用用户名和密码查询
    User getUserByNP(@Param("username") String username, @Param("pwd") String pwd);

    //模糊查询
    List<User> getUserLike(String value);

    //使用用户名和密码查询2(Map)
    User getUserByNP2(Map<String, Object> map);

    //增加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}
