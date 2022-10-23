package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.contact;

import org.junit.jupiter.api.BeforeEach;

class contactTest {

	
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

@Test
void contactIdConstructorTest() {
  contact contact = new contact(contactId);
  assertAll("constructor one",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertNotNull(contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}
// passing in the ID first, making sure they match and then ensuring not nulls.

@Test
void contactTest() {
  contact contact = new contact();
  assertAll("constructor one",
            ()
                -> assertNotNull(contact.getContactId()),
            ()
                -> assertNotNull(contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}
// @ tagging as test for simplicity, should be tagged as regression, linear, smoke, etc. This test is ensuring the contact() isnt null


@Test
void contactIdAndFirstNameConstructorTest() {
  contact contact = new contact(contactId, firstNameTest);
  assertAll("constructor two",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertNotNull(contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}
//checking contact id and first name are matching and then not null

@Test
void contactIdAndFullNameConstructorTest() {
  contact contact = new contact(contactId, firstNameTest, lastNameTest);
  assertAll("constructor three",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertNotNull(contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}
//checking contact id, first and last name then not nullss

@Test
void contactIdFullNamePhoneNumberConstructorTest() {
  contact contact = new contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
  assertAll("constructor four",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> assertNotNull(contact.getAddress()));
}
// making sure the contact id, first n last name, and those digits are matching, making sure that adress aint null

@Test
void itsTheWholeKitAndCaboodle() {
  contact contact = new contact(contactId, firstNameTest, lastNameTest,
                                phoneNumberTest, addressTest);
  assertAll("constructor all",
            ()
                -> assertEquals(contactId, contact.getContactId()),
            ()
                -> assertEquals(firstNameTest, contact.getFirstName()),
            ()
                -> assertEquals(lastNameTest, contact.getLastName()),
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> assertEquals(addressTest, contact.getAddress()));
}
//making sure everything is matching

@Test
void updateContactIdTest() {
  contact contact = new contact();
  contact.updateContactId(contactId);
  assertAll(
      "contact ID",
      ()
          -> assertEquals(contactId, contact.getContactId()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateContactId(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateContactId(tooLongContactId)));
}
// these are trickier, we want to make sure they match, then dem exceptions, - not null and cant be too long

@Test
void updateFirstNameTest() {
  contact contact = new contact();
  contact.updateFirstName(firstNameTest);
  assertAll(
      "first name",
      ()
          -> assertEquals(firstNameTest, contact.getFirstName()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateFirstName(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateFirstName(tooLongFirstName)));
}
// test is clearly for first name

@Test
void updateLastNameTest() {
  contact contact = new contact();
  contact.updateLastName(lastNameTest);
  assertAll(
      "last name",
      ()
          -> assertEquals(lastNameTest, contact.getLastName()),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateLastName(null)),
      ()
          -> assertThrows(IllegalArgumentException.class,
                          () -> contact.updateLastName(tooLongFirstName)));
}
// same test just for last name

@Test
void updatePhoneNumberTest() {
  contact contact = new contact();
  contact.updatePhoneNumber(phoneNumberTest);
  assertAll("phone number",
            ()
                -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updatePhoneNumber(null)),
            ()
                -> assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
            ()
                -> assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updatePhoneNumber(contactId)));
}
// a little bit different we need to make sure it matches, not null, its too long && too long

@Test
void updateAddressTest() {
  contact contact = new contact();
  contact.updateAddress(addressTest);
  assertAll("phone number",
            ()
                -> assertEquals(addressTest, contact.getAddress()),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updateAddress(null)),
            ()
                -> assertThrows(IllegalArgumentException.class,
                                () -> contact.updateAddress(tooLongAddress)));
}
// last one, as always make sure it matches, not null and this one just make sure it doesnt go over 30 okay?

}
