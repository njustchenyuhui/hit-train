package com.sample.dao;

import com.sample.domain.QueryVo;
import com.sample.domain.QueryVolds;
import com.sample.domain.User;

import java.util.List;

/**
 * @创建人 Missbear
 * @创建时间 2018.9.28
 * @描述
 */
public interface IUserDao {
    List<User> findAll();
    User findById(Integer userId);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
    List<User> findByName(String username);
    int count();
    List<User> findByVo(QueryVo vo);
    List<User> findInIds(QueryVolds queryVolds);
}
