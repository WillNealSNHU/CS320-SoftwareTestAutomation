package Main;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;


public class contactService {

	
	  public List<contact> contactList = new ArrayList<>();
	  private String uniqueId;
	  public List<contact> getContactList() { return contactList; }
	  //initialize uniquedID and contactList
	  
	  public void newContact() {
	    contact contact = new contact(newUniqueId());
	    contactList.add(contact);
	  }
	  // method for new contact

	  public void newContact(String firstname) {
	    contact contact = new contact(newUniqueId(), firstname);
	    contactList.add(contact);
	  }
	  //method for new first name

	  public void newContact(String firstname, String lastname) {
		  contact contact = new contact(newUniqueId(), firstname, lastname);
	    contactList.add(contact);
	  }
	  //method for new last name

	  public void newContact(String firstname, String lastname,
	                         String phonenumber) {
		  contact contact =
	        new contact(newUniqueId(), firstname, lastname, phonenumber);
	    contactList.add(contact);
	  }
	  //lemme get those digits

	  public void newContact(String firstname, String lastname, String phonenumber,
	                         String address) {
		  contact contact =
	        new contact(newUniqueId(), firstname, lastname, phonenumber, address);
	    contactList.add(contact);
	  }
	  //method for address

	  public void deleteContact(String id) throws Exception {
	    contactList.remove(searchForContact(id));
	  }
	  //method for deleting a contact

	  public void updateFirstName(String id, String firstName) throws Exception {
	    searchForContact(id).updateFirstName(firstName);
	  }
	  //method for updating a first name

	  public void updateLastName(String id, String lastName) throws Exception {
	    searchForContact(id).updateLastName(lastName);
	  }

	  public void updatePhoneNumber(String id, String phoneNumber)
	      throws Exception {
	    searchForContact(id).updatePhoneNumber(phoneNumber);
	  }
	  //method for updating a last name

	  public void updateAddress(String id, String address) throws Exception {
	    searchForContact(id).updateAddress(address);
	  }
	  //method for updating an address

	  {
		    uniqueId = UUID.randomUUID().toString().substring(
		        0, Math.min(toString().length(), 10));
	  }
	  //method for unique id 
	  
	  private String newUniqueId() {
	    return uniqueId = UUID.randomUUID().toString().substring(
	               0, Math.min(toString().length(), 10));
	  }
	  //method for new unique id's

	  private contact searchForContact(String id) throws Exception {
	    int index = 0;
	    while (index < contactList.size()) {
	      if (id.equals(contactList.get(index).getContactId())) {
	        return contactList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("The Task does not exist!");
	  }
	  //method for searching for a contact
}
