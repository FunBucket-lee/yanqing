package com.qing.dao;

import com.qing.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    User findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User findByName(String username);

    @Insert("Insert INTO user values(null,#{username},#{password})")
    void addUser(User user);
}
