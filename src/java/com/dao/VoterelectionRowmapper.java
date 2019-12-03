/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Voterelection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Selinam
 */
public class VoterelectionRowmapper implements RowMapper<Voterelection>{
    
    @Override
    public Voterelection mapRow(ResultSet rs, int i) throws SQLException
    {
        Voterelection ve = new Voterelection();
        ve.setId(rs.getInt(1));
        ve.setVoterId(rs.getInt(2));
        ve.setElectionId(rs.getInt(3));
        return ve;
    }
    
}


