package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().createContact(new ContactData("FirstTest", "LastTest", "AddressTest", "123456789", "test@test.com", "Test1"));
    app.logout();
  }

}

