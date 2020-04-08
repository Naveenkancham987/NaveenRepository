package com.ibm.examples.jaxrs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.examples.jaxrs.model.Entry;

class EntryRowMapper implements RowMapper<Entry>
{
    @Override
    public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
        Entry entry = new Entry();
        entry.setId(rs.getInt("id"));
        entry.setPhoneNumber(rs.getLong("phonenumber"));
        entry.setFirstName(rs.getString("firstname"));
        entry.setSurName(rs.getString("surname"));
        entry.setAddress(rs.getString("address"));
        return entry;
    }
}
