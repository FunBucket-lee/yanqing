package com.qing.service;

import com.qing.dao.UserMapper;
import com.qing.entity.User;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    SqlSession session = MyBatisUtil.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    @Override
    public User findByNameAndPwd(String username, String password) {
        return mapper.findByNameAndPwd(username, password);
    }

    @Override
    public User findByName(String username) {
        return mapper.findByName(username);
    }

    @Override
    public void addUser(User user) {
        mapper.addUser(user);
        session.commit();
    }
}
