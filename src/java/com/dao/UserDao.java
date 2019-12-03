package com.dao;

import com.model.User;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

public class UserDao {

    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    

    public List checkUser(User u) {
        List<User> k = jdbc.query("select * from user where id='" + u.getId() + "' and password='" + u.getPassword() + "'", new UserRowMapper());
        return k;
    }

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
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUsertype(rs.getString("usertype"));

            users.add(user);
        }
        ps.close();
        return users;
    }
    
    public User getUserById(int id)
    {
       List<User> k  = jdbc.query("select * from user where id ="+id+";", new UserRowMapper());
        try {
            return k.get(0);
        } catch (Exception e) {
            return null;
        }
    }
        
        
}
