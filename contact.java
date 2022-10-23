package Main;

public class contact {
	private static final int CONTACT_PHONENUMBER_LENGTH = 10;
	  private static final byte CONTACT_ID_LENGTH = 10;
	  private static final byte CONTACT_FIRSTNAME_LENGTH = 10;
	  private static final byte CONTACT_LASTNAME_LENGTH = 10;
	  private static final byte CONTACT_ADDRESS_LENGTH = 30;
	  private static final String INITIALIZER = "INITIAL";
	  private static final String INITIALIZER_NUMBER = "1235559999";
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;
	  //initialize all variables

	  public contact() {
	    this.contactId = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUMBER;
	    this.address = INITIALIZER;
	  }
	  //method for contact

	  public contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUMBER;
	    this.address = INITIALIZER;
	  }
	  //pass in contact Id and update it

	  public contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUMBER;
	    this.address = INITIALIZER;
	  }
	  //pass in contact Id and firstname, update them 

	  public contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = INITIALIZER_NUMBER;
	    this.address = INITIALIZER;
	  }
	  //pass ion contact ID, first name and last name, update them

	  public contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIALIZER;
	  }
	  // pass in contact id first and last name and those digits, update

	  public contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }
	  // lastly pass in all of the above + address and update them

	  public void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name is null bro");
	    } else if (firstName.length() > CONTACT_FIRSTNAME_LENGTH) {
	      throw new IllegalArgumentException("Unless your name is Hubert Blaine Wolfe­schlegel­stein­hausen­berger­dorff Sr your name can not "
	    + "be over " + CONTACT_FIRSTNAME_LENGTH + " characters");
	    } else {
	      this.firstName = firstName;
	    }
	  }
	  //make sure first name isnt null then make sure it isnt over 10 characters, throw exceptions if either are true 

	  public void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Everyone has a last name, maybe not a middle name, but last name cannot be null");
	    } else if (lastName.length() > CONTACT_LASTNAME_LENGTH) {
	      throw new IllegalArgumentException("Unless you're the person in Jugemu tales your last name can't exceed 10 characters, currently"
	    + "your last name needs to be " + CONTACT_LASTNAME_LENGTH + " characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }
	  // again make sure the last name isnt null and then make sure it isnt over 10 characters, throw exceptions if either come back true

	  public void updatePhoneNumber(String phoneNumber) {
	    String regexp = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number is null, we gotta have those digits ");
	    } else if (phoneNumber.length() != CONTACT_PHONENUMBER_LENGTH) {
	      throw new IllegalArgumentException(
	          "Too short or too long of a number, remember area code + number, right now the phone number needs to be "
	      + CONTACT_PHONENUMBER_LENGTH + " digits.");
	    } else if (!phoneNumber.matches(regexp)) {
	      throw new IllegalArgumentException(
	          " How you gonna have words in your phone number, try again...");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }
	  // this one is different, we are ensuring its not null, it's exactly 10 digits and no characters, throw exceptions

	  public void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address cant be empty, its currently null");
	    } else if (address.length() > CONTACT_ADDRESS_LENGTH) {
	      throw new IllegalArgumentException("You need a P.O Box or something your address cannot be longer than " 
	    + CONTACT_ADDRESS_LENGTH + " characters");
	    } else {
	      this.address = address;
	    }
	  }
	  // address cant be null or over 30 characters, throw exceptions if either are true throw em

	  public void updateContactId(String contactId) {
	    if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID cannot be empty, its null, time to debug");
	    } else if (contactId.length() > CONTACT_ID_LENGTH) {
	      throw new IllegalArgumentException("Contact ID cant be longer than " + CONTACT_ID_LENGTH + " characters");
	    } else {
	      this.contactId = contactId;
	    }
	  }
	  // not null and not exceeding 10 characters, remember can not update the contact id unlike the other variables + throw those exceptions.
	  
	  public final String getContactId() { return contactId; }

	  public final String getFirstName() { return firstName; }

	  public final String getLastName() { return lastName; }

	  public final String getPhoneNumber() { return phoneNumber; }

	  public final String getAddress() { return address; }
	  
	  //the returns
}
