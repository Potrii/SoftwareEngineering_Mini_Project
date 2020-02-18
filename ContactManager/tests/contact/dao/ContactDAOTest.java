package contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import contact.model.Contact;

class ContactDAOTest {

	private DriverManagerDataSource dataSource;
	private ContactDAO myDAO;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
		dataSource.setUsername("root");
		dataSource.setPassword("mouse69");

		myDAO = new ContactDAOImplementation(dataSource);
	} 

	@Test
	void testSaveContact() {

		Contact myTestContact = new Contact("Georgel", "georgel@yahoo.com", "GeorgelTown", "0264333333");

		int operationResult = myDAO.saveContact(myTestContact);
		assertTrue(operationResult > 0);
	}

	@Test
	void testUpdateContact() {
		Contact myTestContact = new Contact(2,"Georgel", "georgel@yahoo.com", "GeorgelTown", "0264333334");

		int operationResult = myDAO.updateContact(myTestContact);
		assertTrue(operationResult > 0);
	}

	@Test
	void testGetContact() {
		int contactID = 1;
		Contact foundContact = myDAO.getContact(contactID);
		
		if(foundContact!=null) {
			System.out.println(foundContact.toString());
		}
		assertNotNull(foundContact);
	}

	@Test
	void testDeleteContact() {
		int contactID = 2;
		
		int operationResult = myDAO.deleteContact(contactID);
		assertTrue(operationResult > 0);
		
	}

	@Test
	void testListContacts() {
		ArrayList<Contact> contactsList = myDAO.listContacts();
		
		Iterator<Contact> myIterator = contactsList.iterator();
		while(myIterator.hasNext())
		{
			Contact currentContact = myIterator.next();
			System.out.println(currentContact.toString());
		}
		
		assertTrue(contactsList.isEmpty()==false);
	}

}
