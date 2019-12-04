/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Candidate;
import com.model.Party;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.login.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Selinam
 */
public class CandidateDao {

    JdbcTemplate connection;

    public JdbcTemplate getConnection() {
        return connection;
    }

    public void setConnection(JdbcTemplate connection) {
        this.connection = connection;
    }

    public List<Candidate> getCandidate() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        Connection c = new VoteConnection().getConnection();
        System.out.println("11111111111111111");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM candidate");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Candidate candidate = new Candidate();

            candidate.setId(rs.getInt("id"));
            candidate.setName(rs.getString("name"));
            candidate.setParty(getPartyById(rs.getInt("party_id")));
            candidates.add(candidate);
            System.out.println("name=" + rs.getString("name"));
        }
        ps.close();
        return candidates;
    }

    public void setJdcb(JdbcTemplate jdbc) {
        this.connection = jdbc;
    }

    public int save(Candidate ca) {
        byte[] b = "".getBytes();
        String sql = "insert into candidate(name,party_id,image) values('" + ca.getName() + "'," + 1 + ",'" + b + "')";
        return connection.update(sql);
    }

    public List<Candidate> viewAll() {
        return connection.query("select * from candidate", new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int row) throws SQLException {
                Candidate ca = new Candidate();
                ca.setId(rs.getInt(1));
                ca.setName(rs.getString(2));
                ca.setParty(getPartyById(rs.getInt(3)));
                return ca;
            }
        });
    }

    public Party getPartyById(int id) {
        List<Party> k = connection.query("select * from party where id =" + id + ";", new PartyRowmapper());
        try {
            return k.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
