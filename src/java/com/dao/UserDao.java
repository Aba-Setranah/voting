package com.dao;

import com.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    
    public List<User> getUser() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection c = new VoteConnection().getConnection();

        PreparedStatement ps = c.prepareStatement("SELECT * FROM user");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            
            user.setId(rs.getInt("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setPassword(rs.getString("password"));
            user.setUsername(rs.getString("username"));
            user.setUsertype(rs.getString("usertype"));
            users.add(user);
        }
        ps.close();
        return users;
    }
}
