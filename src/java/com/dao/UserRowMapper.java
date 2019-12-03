package com.dao;

import com.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException
    {
        User login = new User();
        login.setId(rs.getInt(1));
        login.setFirstname(rs.getString(2));
        login.setLastname(rs.getString(3));
        login.setUsername(rs.getString(4));
        login.setPassword(rs.getString(5));
        login.setUsertype(rs.getString(6));
        return login;
    }
    
}
