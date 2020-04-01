package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactToGroupTests extends TestBase {

  ContactData contact;
  GroupData group;
  private boolean groupCreated;
  private boolean contactCreated;

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("FirstTest1").withLastname("LastTest4").withAddress("AddressTest").
              withTelHome("123456789").withTelMobile("1233").withTelWork("34444").withEmail("test@test.com")
              .withEmail2("qwe@qwe.com").withEmail3("asd@asd.com"));
      contact = app.db().contacts().iterator().next();
      contactCreated = true;
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test7").withHeader("test8").withFooter("test9"));
      app.goTo().homePage();
      group = app.db().groups().iterator().next();
      groupCreated = true;
    }

    if (!(contactCreated && groupCreated)) {
      for (GroupData g : app.db().groups()) {
        for (ContactData c : app.db().contacts()) {
          if (!c.getGroups().contains(g)) {
            contact = c;
            group = g;
            return;
          }
        }
      }
      contact = app.db().contacts().iterator().next();
      group = new GroupData().withName("test10").withHeader("test11").withFooter("test12");
      app.goTo().groupPage();
      app.group().create(group);
    }
  }

  @Test
  public void testAddContactToGroup() {
    ContactData contactWithAddedGroup = contact.inGroup(group);
    app.goTo().homePage();
    app.contact().addInSelectedGroup(contact.getId(), group.getName());
    assertThat(contact.getGroups(), equalTo(contactWithAddedGroup.getGroups().withAdded(group)));
  }
}

