package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("FirstTest", "LastTest", "AdressTest", "123456789", "test@test.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    app.logout();
  }



  }

