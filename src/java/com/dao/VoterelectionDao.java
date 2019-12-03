/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Voterelection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class VoterelectionDao {
    
    
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    
    
    public Voterelection getVoterelectionById(int id)
    {
       List<Voterelection> k  = jdbc.query("select * from Voterelection where voter_id ="+id+";", new VoterelectionRowmapper());
        try {
            return k.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
