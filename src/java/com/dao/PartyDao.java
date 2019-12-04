package com.dao;

import com.model.Party;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Selinam
 */
public class PartyDao {
    
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Party getPartyById(int id) {
        List<Party> k  = jdbc.query("select * from party where id ="+id+";", new PartyRowmapper());
        try {
            return k.get(0);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Party> getParty() throws SQLException {
        List<Party> parties = new ArrayList<>();
        Connection c = new VoteConnection().getConnection();
        System.out.println("11111111111111111");
        PreparedStatement ps = c.prepareStatement("SELECT * FROM party");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Party party = new Party();
            
            party.setId(rs.getInt("id"));
            party.setName(rs.getString("name"));
            parties.add(party);
            System.out.println("name= "+rs.getString("name"));
           
        }
        ps.close();
        return parties;
    }
   
}
