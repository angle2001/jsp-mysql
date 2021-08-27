package com.dao;

import com.pojo.User;
import java.util.List;

public interface UserDao {
   User login(String username,String password);
   List <User> findAll();
   int addUser(User user);
   int deleteUser(Integer id);
   void deleteByIds(String[] ids);
   User findById(Integer id);
   int updateUser(User user);
   List<User> findByCondition(String name,String gender,String age);
}
