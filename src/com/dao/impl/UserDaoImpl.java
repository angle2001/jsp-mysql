package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    Connection conn=null;
    PreparedStatement pstat = null;
    ResultSet rs = null;
    public User login(String username, String password) {

        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from message where username=? and password=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,username);
            pstat.setString(2,password);
            rs=pstat.executeQuery();
            User user = null;
            while(rs.next()) {
                user=new User();
                String uname=rs.getString("username");
                String pwd=rs.getString("password");
                user.setUsername(username);
                user.setPassword(password);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<User> findAll(){
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from message";
            pstat = conn.prepareStatement(sql);
            rs=pstat.executeQuery();
            User user = null;
            List<User> list =new ArrayList<>();
            while(rs.next()) {
                user=new User();
                int id=rs.getInt("id");
                int age=rs.getInt("age");
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                String birthday=rs.getString("birthday");
                String username=rs.getString("username");
                String password=rs.getString("password");
                user.setId(id);
                user.setAge(age);
                user.setName(name);
                user.setGender(gender);
                user.setBirthday(birthday);
                user.setUsername(username);
                user.setPassword(password);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int addUser(User user){
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into message(name,gender,age,birthday,username,password) values(?,?,?,?,?,?) ";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getGender());
            pstat.setInt(3, user.getAge());
            pstat.setString(4, user.getBirthday());
            pstat.setString(5, user.getUsername());
            pstat.setString(6, user.getPassword());
            int i=pstat.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstat,conn);
        }
        return 0;
    }

    @Override
    public int deleteUser(Integer id) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete  from message where id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, id);
            int i=pstat.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstat,conn);
        }
        return 0;
    }

    @Override
    public void deleteByIds(String[] ids) {
        for (String id:ids){
             deleteUser(Integer.parseInt(id));
        }
    }

    @Override
    public User findById(Integer id) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from message where id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,id);
            rs=pstat.executeQuery();
            User user = null;
            while(rs.next()) {
                user=new User();
                int ids=rs.getInt("id");
                int age=rs.getInt("age");
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                String birthday=rs.getString("birthday");
                String username=rs.getString("username");
                String password=rs.getString("password");
                user.setId(ids);
                user.setAge(age);
                user.setName(name);
                user.setGender(gender);
                user.setBirthday(birthday);
                user.setUsername(username);
                user.setPassword(password);

            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(User user) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update message set name=?,gender =?,age=?,birthday =?,username=?,password=? where id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, user.getName());
            pstat.setString(2, user.getGender());
            pstat.setInt(3, user.getAge());
            pstat.setString(4, user.getBirthday());
            pstat.setString(5, user.getUsername());
            pstat.setString(6, user.getPassword());
            pstat.setInt(7,user.getId());
            int i=pstat.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(rs,pstat,conn);
        }
        return 0;
    }

    @Override
    public List<User> findByCondition(String name1, String gender1, String age1) {
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from message where 1=1";
            StringBuffer sb=new StringBuffer(sql);
            List l=new ArrayList();
            if (name1!=null&&(!name1.equals(""))){
                sb.append(" and name like '%' ? '%' ");
                l.add(name1);
            }
            if (gender1!=null&&(!gender1.equals(""))){
                sb.append(" and gender like '%' ? '%' ");
                l.add(gender1);
            }
            int age2=0;
            if (age1!=null&&(!age1.equals(""))){
                age2=Integer.parseInt(age1);
                sb.append(" and age =  ");
                l.add(age2);
            }

            pstat = conn.prepareStatement(sb.toString());
            for (int i=1;i<=l.size();i++){
                pstat.setObject(i,l.get(i-1));
            }
            rs=pstat.executeQuery();
            User user = null;
            List<User> list =new ArrayList<>();
            while(rs.next()) {
                user=new User();
                int id=rs.getInt("id");
                int age=rs.getInt("age");
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                String birthday=rs.getString("birthday");
                String username=rs.getString("username");
                String password=rs.getString("password");
                user.setId(id);
                user.setAge(age);
                user.setName(name);
                user.setGender(gender);
                user.setBirthday(birthday);
                user.setUsername(username);
                user.setPassword(password);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
