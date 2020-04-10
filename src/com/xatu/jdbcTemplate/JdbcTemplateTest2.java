package com.xatu.jdbcTemplate;

import com.xatu.pojo.emp;
import com.xatu.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Auther WeiLGHui
 * @Date 2020-04-07 23:34
 */
public class JdbcTemplateTest2 {
    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());


    /**
     * 更新操作
     */
    @Test
    public void test1() {
        String sql = "update emp set salary = ? where id =?";
        int count = template.update(sql, 10000, 1);
        System.out.println(count);
    }

    /**
     * 添加操作
     */
    @Test
    public void test2() {
        String sql = "insert into emp values(null,?,?,?,?,?)";
        int count = template.update(sql, "白龙马", "男", 6000, "2014-12-11", 2);
        System.out.println(count);
    }

    /**
     * 删除操作
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 6);
        System.out.println(count);
    }

    /**
     * 查询操作
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }

    /**
     * 查询所有，并封装一个List集合
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> map = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : map) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 将所有查询出来的数据封装成对象
     */
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<emp> list = template.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for (emp e:
             list) {
            System.out.println(e);
        }
    }

    /**
     * 查询个数
     */
    @Test
    public void test7() {
        String sql = "select count(id) from emp";
        Long all = template.queryForObject(sql, Long.class);
        System.out.println(all);
    }
}
