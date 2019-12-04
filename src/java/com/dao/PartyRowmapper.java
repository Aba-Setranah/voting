package com.dao;

import com.model.Party;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Selinam
 */
public class PartyRowmapper implements RowMapper<Party> {
    
    @Override
    public Party mapRow(ResultSet rs, int i) throws SQLException
    {
        Party p = new Party();
        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        return p;
    }
}
