package com.xatu.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Auther WeiLGHui
 * @Date 2020-04-07 21:48
 */
public class testDemo2 {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream is = testDemo2.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);           //加载配置文件

        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
