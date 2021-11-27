package com.code.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.code.contact.model.Contacts;

import javax.sql.DataSource;
/**
 * @author Aqeel
 *
 */
public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;

	public ContactDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Contacts contact) {
		if (contact.getId() > 0) {
			// updating an existing record
			String sql = "UPDATE contacts SET name=?, email=?, address=?, "
					+ "phone=? WHERE id=?";

			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone(), contact.getId());
		} else {
			// inserting record
			String sql = "INSERT INTO contacts (name, email, address, phone)"
					+ " VALUES (?, ?, ?, ?)";

			jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),
					contact.getAddress(), contact.getTelephone());
		}
	}

	/*********   *********   *********/

	@Override
	public int delete(int contactId) {
		String sql = "DELETE FROM Contacts WHERE id=?";
		return jdbcTemplate.update(sql, contactId);
	}


	@Override
	public List<Contacts> list() {
		String sql = "SELECT * FROM Contacts";
		List<Contacts> listContact = jdbcTemplate.query(sql, new RowMapper<Contacts>() {

			@Override
			public Contacts mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contacts aContact = new Contacts();

				aContact.setId(rs.getInt("id"));
				aContact.setName(rs.getString("name"));
				aContact.setEmail(rs.getString("email"));
				aContact.setAddress(rs.getString("address"));
				aContact.setTelephone(rs.getString("phone"));

				return aContact;
			}

		});

		return listContact;
	}

	@Override
	public Contacts get(int contactId) {
		String sql = "SELECT * FROM contacts WHERE id=" + contactId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Contacts>() {

			@Override
			public Contacts extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				if (rs.next()) {
					Contacts contact = new Contacts();
					contact.setId(rs.getInt("id"));
					contact.setName(rs.getString("name"));
					contact.setEmail(rs.getString("email"));
					contact.setAddress(rs.getString("address"));
					contact.setTelephone(rs.getString("phone"));
					return contact;
				}

				return null;
			}

		});
	}

}
