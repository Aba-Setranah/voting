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
import org.springframework.jdbc.core.RowMapper;
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

    public User getUserById(int id) {
        List<User> k = jdbc.query("select * from user where id =" + id + ";", new UserRowMapper());
        try {
            return k.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public int save(User u) {

        String sql = "insert into user(firstname,lastname,username,password,usertype) values('" + u.getFirstname() + "','" + u.getLastname() + "','" + u.getUsername() + "','" + u.getPassword() + "','" + u.getUsertype() + "')";
        return jdbc.update(sql);
    }

    public List<User> viewAll() {
        return jdbc.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setFirstname(rs.getString(2));
                u.setLastname(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setUsertype(rs.getString(6));

                return u;
            }
        });
    }
}
