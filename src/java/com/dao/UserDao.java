package com.dao;

import com.model.User;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    
    JdbcTemplate jdbc;

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    public List checkUser(User u)
    {
        List <User> k=jdbc.query("select * from user where id='"+u.getId()+"' and password='"+u.getPassword()+"'",new UserRowMapper() );
        return k;
    }
    
    
    
   
}
