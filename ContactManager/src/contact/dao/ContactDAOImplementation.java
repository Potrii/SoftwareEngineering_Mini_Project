package contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import contact.model.Contact;

public class ContactDAOImplementation implements ContactDAO {

	private JdbcTemplate jdbcTemplate;

	public ContactDAOImplementation(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int saveContact(Contact myContact) {
		String sqlQuery = "INSERT INTO contacts (Name, Email, Address, PhoneNumber) VALUES (?, ?, ?, ?)";

		return jdbcTemplate.update(sqlQuery, myContact.getName(), myContact.getEmail(), myContact.getAddress(),
				myContact.getPhoneNumber());
	}

	@Override
	public int updateContact(Contact myContact) {
		String sqlQuery = "UPDATE contacts SET Name = ? ,Email=?,  Address = ? ,PhoneNumber = ? WHERE ID=? ";

		return jdbcTemplate.update(sqlQuery, myContact.getName(), myContact.getEmail(), myContact.getAddress(),
				myContact.getPhoneNumber(), myContact.getID());
	}

	@Override
	public Contact getContact(int contactID) {
		String sqlQuery = "SELECT * FROM contacts WHERE ID=" + contactID;

		ResultSetExtractor<Contact> resultSetExtractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next() == true) {
					String name=rs.getString("Name");
					String email=rs.getString("Email");
					String address=rs.getString("Address");
					String phone=rs.getString("PhoneNumber");
					
					return new Contact(contactID, name, email, address, phone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sqlQuery,resultSetExtractor);
	}

	@Override
	public int deleteContact(int contactID) {
		String sqlQuery = "DELETE FROM contacts WHERE ID="+contactID;
		return jdbcTemplate.update(sqlQuery);
	}

	@Override
	public ArrayList<Contact> listContacts() {
		String sqlQuery = "SELECT * FROM contacts";
		
		ArrayList<Contact> contactList = (ArrayList<Contact>) jdbcTemplate.query(sqlQuery, new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Contact currentContact = new Contact();
				
				int id = rs.getInt("ID");
				String name=rs.getString("Name");
				String email=rs.getString("Email");
				String address=rs.getString("Address");
				String phone=rs.getString("PhoneNumber");
				
				currentContact.setID(id);
				currentContact.setName(name);
				currentContact.setEmail(email);
				currentContact.setAddress(address);
				currentContact.setPhoneNumber(phone);
				
				
				return currentContact;
			}
			
		});
		return contactList;
	}

}
