package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactFromGroupTests extends TestBase{
  private ContactData contact;
  private GroupData group;
  private boolean contactCreated;
  private boolean groupCreated;

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("FirstTest1").withLastname("LastTest4").withAddress("AddressTest").
              withTelHome("123456789").withTelMobile("1233").withTelWork("34444").withEmail("test@test.com")
              .withEmail2("qwe@qwe.com").withEmail3("asd@asd.com"));
      contactCreated = true;
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test7").withHeader("test8").withFooter("test9"));
      app.goTo().homePage();
      groupCreated = true;
    }

    if (!(contactCreated && groupCreated)) {
      for (ContactData c : app.db().contacts()) {
        if (c.getGroups().size() != 0) {
          contact = c;
          group = c.getGroups().iterator().next();
          return;
        }
      }
    }
    contact = app.db().contacts().iterator().next();
    group = app.db().groups().iterator().next();
    app.goTo().homePage();
    app.contact().addInSelectedGroup(contact.getId(), group.getName());
  }
  
  @Test
  public void testDeleteContactFromGroup() {
    Contacts before = app.db().contacts();
    ContactData contactWithoutGroup = contact.removeOfGroup(group);
    app.goTo().homePage();
    app.contact().deleteFromSelectedGroup(contact.getId(), group.getName());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(contact).withAdded(contactWithoutGroup)));
  }
}
