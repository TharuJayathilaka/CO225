package contacts;

public class person {
	private String FirstName; 
	private String LastName; 
	private String PhoneNumber;
	
	//By using getters and getters  get and set variables
	public String getFirstName() {    
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	} 

}
