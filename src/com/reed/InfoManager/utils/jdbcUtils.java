package com.reed.InfoManager.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbcUtils {
    private static DataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource("mysql");
    }

    /**
     * ��ȡһ�����ݿ�����
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * �ر�һ�����ݿ�����
     * @param connection
     */
    public static void close(Connection connection){
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
