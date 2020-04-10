package com.xatu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xatu.jdbcTemplate.JdbcTemlateTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther WeiLGHui
 * @Date 2020-04-07 23:29
 */

/**
 * JDBC工具类
 */
public class JdbcUtils {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JdbcTemlateTest.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

}
