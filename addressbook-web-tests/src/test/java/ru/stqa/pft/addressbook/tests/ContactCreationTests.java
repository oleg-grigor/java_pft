package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("FirstTest", "LastTest", "AddressTest", "123456789", "test@test.com", "Test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logout();
  }

  }

