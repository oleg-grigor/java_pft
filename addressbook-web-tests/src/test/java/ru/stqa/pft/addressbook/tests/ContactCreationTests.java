package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("FirstTest1").withLastname("LastTest4").withAddress("AddressTest").
            withTelHome("123456789").withEmail("test@test.com").withGroup("Test1");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}

