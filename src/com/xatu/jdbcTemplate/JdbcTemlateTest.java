package com.xatu.jdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xatu.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther WeiLGHui
 * @Date 2020-04-07 23:17
 */
public class JdbcTemlateTest {


    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        int count = template.update("insert into account values(null,?,?)", "hhh", 500);
        System.out.println(count);
    }
}
