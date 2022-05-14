package com.kuiniu.jdbc;

import com.kuiniu.bean.Act_id_user;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * spring连接池JdbcTemplate
 */
public class JDBCTemplateDemo {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update act_id_user set FIRST_ = ? where ID_ = ?";
        jt.update(sql,  "11-2name", 1111);

        //将查询封装为list集合
        ArrayList<Map<String, Object>> users = (ArrayList<Map<String, Object>>) jt.queryForList("select * from act_id_user where ID_ in (1111, 22)");
        System.out.println(users);

        //将查询封装为JavaBean
        String sql1 = "select * from act_id_user where ID_ = ?";
        ArrayList<Act_id_user> users1 = (ArrayList<Act_id_user>) jt.query(sql1, new RowMapper<Act_id_user>() {
            //将此方法的返回值一个一个的放回到jt.query方法结果集中
            @Override
            public Act_id_user mapRow(ResultSet rs, int i) throws SQLException {
                Act_id_user user1 = new Act_id_user();
                user1.setID_(rs.getInt("ID_"));
                user1.setFIRST_(rs.getString("FIRST_"));
                user1.setLAST_(rs.getString("LAST_"));
                user1.setREV_(rs.getInt("REV_"));
                user1.setEMAIL_(rs.getString("EMAIL_"));
                user1.setPWD_(rs.getString("PWD_"));
                return user1;
            }
        }, 1111);
//        Act_id_user user = (Act_id_user) jt.query(sql1, 22);
        System.out.println(users1.get(0) + " 1 1");
    }
}
