package com.reed.InfoManager.dao;

import com.reed.InfoManager.model.User;
import com.reed.InfoManager.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class managerDao {
    QueryRunner qr = new QueryRunner();

    /**
     * �����û���Ϣ
     * @param user
     */
    public int add(User user){
        Connection conn = null;
        int rows = 0;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "INSERT INTO users VALUES (?,?,?,?,?,?);";
            Object[] params = {user.getId(),user.getUsername(),user.getPassword(),
                    user.getPhone(),user.getAddress(),user.getInfo()};
            if (user.getUsername().equals("") || user.getPassword().equals("")) {
                rows = 0;
            } else {
                rows = qr.update(conn, sql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return rows;
    }

    /**
     *�����û�idɾ���û�
     * @param id
     */
    public int delete(int id){
        Connection conn = null;
        int rows = 0;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "DELETE FROM users WHERE id=?;";
            rows = qr.update(conn, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return rows;
    }

    /**
     * �����û�������ַ��绰����ģ�������û�
     * @param username
     * @param address
     * @param phone
     * @return
     */
    public List<User> search(String username, String address, String phone){
        Connection conn = null;
        List<User> users = null;
        String sql = "SELECT * FROM users WHERE 1=1";
        if (username != null && !("".equals(username))){
            sql = sql + " AND username LIKE '%" + username + "%'";
        }
        if (address != null && !("".equals(address))){
            sql = sql + " AND address LIKE '%" + address + "%'";
        }
        if (phone != null && !("".equals(phone))){
            sql = sql + " AND phone LIKE '%" + phone + "%'";
        }
        try {
            conn = jdbcUtils.getConnection();
            users = qr.query(conn, sql, new BeanListHandler<User>(User.class));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return users;
    }

    /**
     * �����û���Ϣ
     * @param user
     */
    public int update(User user){
        Connection conn = null;
        int rows = 0;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "UPDATE users SET username = ?,password = ?,phone = ?,address = ?,info = ? WHERE id = ?;";
            Object[] params = {user.getUsername(),user.getPassword(),user.getPhone(),user.getAddress(),user.getInfo(),user.getId()};
            rows = qr.update(conn,sql,params);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return rows;
    }

    /**
     * �����û�id��ȡһ���û���Ϣ
     * @param id
     * @return
     */
    public User get(int id){
        Connection conn = null;
        User user = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "SELECT * FROM users WHERE id = ?;";
            user = qr.query(conn, sql, new BeanHandler<>(User.class), id);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return user;
    }

    /**
     * ��ȡȫ�����û���Ϣ
     * @return
     */
    public List<User> getAll(){
        Connection conn = null;
        List<User> users = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "SELECT * FROM users;";
            users = qr.query(conn, sql, new BeanListHandler<>(User.class));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return users;
    }

    /**
     * �����û����õ���ͬ�û����ĸ���
     * @param username
     * @return
     */
    public int getCount(String username){
        Connection conn = null;
        int rows = 0;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "SELECT * FROM users WHERE username = ?;";
            rows = qr.query(conn, sql, new ScalarHandler<>(), username);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return rows;
    }

    /**
     * ��֤�û���������ʵ�ֵ�¼
     * @param username
     * @param password
     */
   public User login(String username, String password){
        Connection conn = null;
        User user = null;
        try {
            conn = jdbcUtils.getConnection();
            String sql = "SELECT * FROM users WHERE";
            if (!("".equals(username)) && !("".equals(password))) {
                sql = sql + " username=\"" + username + "\" and password=\"" + password +"\"";
                user = qr.query(conn, sql, new BeanHandler<User>(User.class));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return user;
   }
}
