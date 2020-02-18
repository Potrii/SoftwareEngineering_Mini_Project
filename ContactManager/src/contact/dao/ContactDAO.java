package contact.dao;

import java.util.ArrayList;

import contact.model.Contact;

public interface ContactDAO {

	public int saveContact (Contact myContact);
	
	public int updateContact (Contact myContact);
	
	public Contact getContact (int contactID);
	
	public int deleteContact (int contactID);
	
	public ArrayList<Contact> listContacts();
}
