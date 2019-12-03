/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.model.Candidate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.login.Configuration;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Selinam
 */
public class CandidateDao {
    
    JdbcTemplate jdbc;
    
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
            candidates.add(candidate);
            System.out.println("name="+rs.getString("name"));
        }
        ps.close();
        return candidates;
    }
    
//   public int addCandidate(Candidate ca) throws SQLException {
//        Connection c = new VoteConnection().getConnection();
//        
//        PreparedStatement ps = c.prepareStatement("insert into candidate(name, party_id) values(?,?)");
//        ps.setString(1, ca.getName());
//        ps.setInt(2,ca.getParty().getId() );
//        
//
//        int x = ps.executeUpdate();
//       
//        ps.close();
//        return x;
//    }
     
    public void setJdcb(JdbcTemplate jdbc){
       this.jdbc = jdbc;
    }
    
    public int save(Candidate ca){
        String sql="insert into candidate(name,party_id) values('"+ca.getName()+"',"+ca.getParty().getId()+")";
        return jdbc.update(sql);
    }
    
    public List<Candidate> viewAll(){
        return jdbc.query("select * from candidate", new RowMapper <Candidate>(){
        @Override
        public Candidate mapRow(ResultSet rs, int row)throws SQLException{
            Candidate ca= new Candidate();
            ca.setId(rs.getInt(1));
            ca.setName(rs.getString(2));
            //ca.setParty(rs.getInt());
//            ca.setImage(rs.getInt());
            return ca;
        }
        });
    }
}
