package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("FirstTestMod", "LastTestMod", "AddressTestMod", "123456789", "testMod@test.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }


}
