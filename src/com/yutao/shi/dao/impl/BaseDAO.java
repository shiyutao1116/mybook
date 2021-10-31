package com.yutao.shi.dao.impl;

import com.yutao.shi.utils.JdbcU;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author shiyutao
 * @create 2021-10-15 12:36
 */
public abstract class BaseDAO {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = JdbcU.getconnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public <T> T searchone(Class<T>type,String sql, Object... args) {
        Connection connection = JdbcU.getconnection();
        try {
             return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
    public <T> List<T> searchmany(Class<T>type, String sql, Object... args) {
        Connection connection = JdbcU.getconnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
    public Object searchforsinglevalue(String sql, Object... args) {
        Connection connection = JdbcU.getconnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}