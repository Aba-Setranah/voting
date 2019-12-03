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

/**
 *
 * @author Selinam
 */
public class CandidateDao {
    
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
}
