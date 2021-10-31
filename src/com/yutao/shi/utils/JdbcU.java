package com.yutao.shi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.scenario.effect.impl.prism.ps.PPStoPSWDisplacementMapPeer;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shiyutao
 * @create 2021-10-14 20:12
 */
public class JdbcU {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<Connection>();
    static {
        try {
            Properties pros = new Properties();
            InputStream is = JdbcU.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static Connection getconnection(){
        Connection conn= conns.get();
        if(conn==null){
            try {
                conn=dataSource.getConnection();
                conns.set(conn);
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;

        /* Connection connection= null;
    try {
        connection = dataSource.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return connection;*/
}
    public static void  commitandclose(){
        Connection conn = conns.get();

        if(conn!=null){
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
            conns.remove();

    }
    public  static void rollbackadnclose(){

        Connection conn = conns.get();

        if(conn!=null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        conns.remove();






    }

















/*
public static void closeconnection(Connection connection){
if(connection!=null){
    try {
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }


}
    }
*/

}
