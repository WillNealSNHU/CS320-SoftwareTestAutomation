package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import Main.contactService;

import org.junit.jupiter.api.BeforeEach;

class contactServiceTest {


	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
    addressTest;
	protected String tooLongContactId, tooLongFirstName, tooLongLastName,
    tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;
//initialize initialize

@BeforeEach
void setUp() {
  contactId = "J117N7OBI1";
  firstNameTest = "Ryan";
  lastNameTest = "Cohen";
  phoneNumberTest = "4128675309";
  addressTest = "625 Westport Pkwy Grapevine TX";
  tooLongContactId = "314159265358979323"; 
  tooLongFirstName = "Ken the Liar";
  tooLongLastName = "Steals-your-money Griffin";
  tooLongPhoneNumber = "41299934781";
  tooShortPhoneNumber = "86753091";
  tooLongAddress = "625 Westport Pkwy., Grapevine, TX, 76051";
}
//set up before each test

// just grabbed my stuff from contactTest for ease of use

@Test
void newContactTest() {
  contactService contactService = new contactService();
  contactService.newContact();
  assertAll(
      "service",
      ()
          -> assertNotNull(contactService.getContactList().get(0).getContactId()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(0).getFirstName()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(0).getLastName()),
      ()
          -> assertEquals("1235559999",
        		  contactService.getContactList().get(0).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(0).getAddress()));
  contactService.newContact(firstNameTest);
  assertAll(
      "service",
      ()
          -> assertNotNull(contactService.getContactList().get(1).getContactId()),
      ()
          -> assertEquals(firstNameTest,
        		  contactService.getContactList().get(1).getFirstName()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(1).getLastName()),
      ()
          -> assertEquals("1235559999",
        		  contactService.getContactList().get(1).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(1).getAddress()));
  contactService.newContact(firstNameTest, lastNameTest);
  assertAll(
      "service",
      ()
          -> assertNotNull(contactService.getContactList().get(2).getContactId()),
      ()
          -> assertEquals(firstNameTest,
        		  contactService.getContactList().get(2).getFirstName()),
      ()
          -> assertEquals(lastNameTest,
        		  contactService.getContactList().get(2).getLastName()),
      ()
          -> assertEquals("1235559999",
        		  contactService.getContactList().get(2).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(2).getAddress()));
  contactService.newContact(firstNameTest, lastNameTest, phoneNumberTest);
  assertAll(
      "service",
      ()
          -> assertNotNull(contactService.getContactList().get(3).getContactId()),
      ()
          -> assertEquals(firstNameTest,
        		  contactService.getContactList().get(3).getFirstName()),
      ()
          -> assertEquals(lastNameTest,
        		  contactService.getContactList().get(3).getLastName()),
      ()
          -> assertEquals(phoneNumberTest,
        		  contactService.getContactList().get(3).getPhoneNumber()),
      ()
          -> assertEquals("INITIAL",
        		  contactService.getContactList().get(3).getAddress()));
  contactService.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                     addressTest);
  assertAll(
      "service",
      ()
          -> assertNotNull(contactService.getContactList().get(4).getContactId()),
      ()
          -> assertEquals(firstNameTest,
        		  contactService.getContactList().get(4).getFirstName()),
      ()
          -> assertEquals(lastNameTest,
        		  contactService.getContactList().get(4).getLastName()),
      ()
          -> assertEquals(phoneNumberTest,
        		  contactService.getContactList().get(4).getPhoneNumber()),
      ()
          -> assertEquals(addressTest,
        		  contactService.getContactList().get(4).getAddress()));
}
// run through everything

@Test
void updateFirstNameTest() throws Exception {
  contactService contactService = new contactService();
  contactService.newContact();
  contactService.updateFirstName(contactService.getContactList().get(0).getContactId(),
                          firstNameTest);
  assertEquals(firstNameTest, contactService.getContactList().get(0).getFirstName());
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateFirstName(
                		   contactService.getContactList().get(0).getContactId(),
                       tooLongFirstName));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateFirstName(
                		   contactService.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> contactService.updateFirstName(contactId, firstNameTest));
}
//this test is checking the updated first name, again make sure it equals to, not null and cant be too long

@Test
void updateLastNameTest() throws Exception {
  contactService contactService = new contactService();
  contactService.newContact();
  contactService.updateLastName(contactService.getContactList().get(0).getContactId(),
                         lastNameTest);
  assertEquals(lastNameTest, contactService.getContactList().get(0).getLastName());
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateLastName(
                		   contactService.getContactList().get(0).getContactId(),
                       tooLongLastName));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateLastName(
                		   contactService.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> contactService.updateLastName(contactId, lastNameTest));
}
// same thing with our last name, updated matching not null and not too long

@Test
void updatePhoneNumberTest() throws Exception {
  contactService contactService = new contactService();
  contactService.newContact();
  contactService.updatePhoneNumber(contactService.getContactList().get(0).getContactId(),
                            phoneNumberTest);
  assertEquals(phoneNumberTest,
		  contactService.getContactList().get(0).getPhoneNumber());
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updatePhoneNumber(
                		   contactService.getContactList().get(0).getContactId(),
                       tooLongPhoneNumber));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updatePhoneNumber(
                		   contactService.getContactList().get(0).getContactId(),
                       tooShortPhoneNumber));
  assertThrows(
      IllegalArgumentException.class,
      ()
          -> contactService.updatePhoneNumber(
        		  contactService.getContactList().get(0).getContactId(), contactId));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updatePhoneNumber(
                		   contactService.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> contactService.updatePhoneNumber(contactId, lastNameTest));
}
// again the phone number has a little bit more in the way of moving parts
// we are checking the updated number to make sure it isnt too long, too short, isnt null
// as always get them digits!

@Test
void updateAddressTest() throws Exception {
  contactService contactService = new contactService();
  contactService.newContact();
  contactService.updateAddress(contactService.getContactList().get(0).getContactId(),
                        addressTest);
  assertEquals(addressTest, contactService.getContactList().get(0).getAddress());
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateAddress(
                		   contactService.getContactList().get(0).getContactId(),
                       tooLongAddress));
  assertThrows(IllegalArgumentException.class,
               ()
                   -> contactService.updateAddress(
                		   contactService.getContactList().get(0).getContactId(), null));
  assertThrows(Exception.class,
               () -> contactService.updateAddress(contactId, addressTest));
}
// here we are checking the address, my naming conventions are either really good or really bad 
// because this again should be self explanatory update, match, not null and not too long

@Test
void deleteContactTest() {
  contactService contactService = new contactService();
  contactService.newContact();
  assertThrows(Exception.class, () -> contactService.deleteContact(contactId));
  assertAll(()
                -> contactService.deleteContact(
                		contactService.getContactList().get(0).getContactId()));
}
//this one was super easy, make sure the contact is gone, byyyeeeee

}
