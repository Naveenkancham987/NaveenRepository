package com.ibm.examples.jaxrs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ibm.examples.jaxrs.model.Entry;

@Repository
public class PhoneRepositoryImpl implements PhoneRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Entry> getEntries() {
		return jdbcTemplate.query("select * from phonebook", new EntryRowMapper());
	}

	@Override
	public Entry addEntry(Entry entry) {
		return create(entry);
	}

		
	@Override
	public List<Entry> searchEntryBySurname(String surname){
		List<Entry> entry=  jdbcTemplate.query("select * from phonebook where surname=?",
				new EntryRowMapper(),surname);
		return entry;
	}
	
	@Override
    public int deleteEntry(int id) {
        return jdbcTemplate.update(
                "delete from phonebook where  id  = ?", id);
        
    }
	
	public Entry create(final Entry entry) 
    {
        final String sql = "insert into phonebook(firstname,surname,phonenumber,address) values(?,?,?,?)";
 
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, entry.getFirstName());
                ps.setString(2, entry.getSurName());
                ps.setLong(3, entry.getPhoneNumber());
                ps.setString(4,entry.getAddress());
                return ps;
            }
        }, holder);
 
        return entry ;
        
    }
	
}
