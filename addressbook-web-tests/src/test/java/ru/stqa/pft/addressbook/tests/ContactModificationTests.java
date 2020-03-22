package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData().withFirstname("FirstTest").withLastname("LastTest").withAddress( "AddressTest").
              withTelHome("123456789").withEmail("test@test.com").withGroup("Test1"));
    }
  }

  @Test
  public void testContactModification () {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();

    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("FirstTest1").withLastname("LastTest4").withAddress("AddressTest").
            withTelHome("123456789").withTelMobile("1233").withTelWork("34444").withEmail("test@test.com")
            .withEmail2("qwe@qwe.com").withEmail3("asd@asd.com").withGroup("Test1").withPhoto(photo);
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}
