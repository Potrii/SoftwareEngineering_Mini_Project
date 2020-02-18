package contact.model;

public class Contact {

	private int ID;
	private String Name;
	private String Email;
	private String Address;
	private String PhoneNumber;

	public Contact(int iD, String name, String email, String address, String phoneNumber) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		Address = address;
		PhoneNumber = phoneNumber;
	}
	
	public Contact(String name, String email, String address, String phoneNumber) {
		Name = name;
		Email = email;
		Address = address;
		PhoneNumber = phoneNumber;
	}
	
	public Contact()
	{
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	

	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Contact [ID=" + ID + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + ", PhoneNumber="
				+ PhoneNumber + "]";
	}
	
}
