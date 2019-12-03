/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.ElectionVote;
import com.model.Vote;
import com.model.Voterelection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDao {

    public int addvote(Vote v) throws SQLException {
        Connection c = new VoteConnection().getConnection();

        PreparedStatement ps = c.prepareStatement("insert into vote(election_id, candidate_id) values(?,?)");
        ps.setInt(1, v.getElectionId());
        ps.setInt(2, v.getCandidateId());

        int x = ps.executeUpdate();
        ps.close();
        return x;
    }

    public List<ElectionVote> getAllVotes() throws SQLException {
        List<ElectionVote> electionVotes = new ArrayList<>();
        Connection c = new VoteConnection().getConnection();

        PreparedStatement ps = c.prepareStatement("SELECT c.name, COUNT(*) AS votes \n"
                + "FROM candidate c \n"
                + "INNER JOIN vote v ON v.candidate_id=c.id\n"
                + "GROUP BY c.id");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ElectionVote v = new ElectionVote();
            v.setName(rs.getString("name"));
            v.setVotes(rs.getInt("votes"));
            electionVotes.add(v);
        }
        ps.close();
        return electionVotes;
    }

    public int addelectionvote(Voterelection ve) throws SQLException {
        
        Connection c = new VoteConnection().getConnection();

        PreparedStatement ps = c.prepareStatement("insert into voterelection(election_id, voter_id) values(?,?)");
        ps.setInt(1, ve.getElectionId());
        ps.setInt(2, ve.getVoterId());

        int x = ps.executeUpdate();
        ps.close();
        return x;
    }
}
