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

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("FirstTest1").withLastname("LastTest4").withAddress("AddressTest").
              withTelHome("123456789").withTelMobile("1233").withTelWork("34444").withEmail("test@test.com")
              .withEmail2("qwe@qwe.com").withEmail3("asd@asd.com"));
    }

    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("test7").withHeader("test8").withFooter("test9"));
      app.goTo().homePage();
    }

    if (app.db().contacts().iterator().next().getGroups().size() == 0) {
      app.contact().addInSelectedGroup(app.db().contacts().iterator().next().getId(), app.db().groups().iterator().next().getId());
      app.goTo().homePage();
    }
  }

  @Test
  public void testDeleteContactFromGroup() {

    //Groups group = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int id = contact.getId();
    Set<GroupData> groupsOfContact = contact.getGroups();

    if (!groupsOfContact.isEmpty()) {
      int index = groupsOfContact.iterator().next().getId();
      app.contact().deleteFromSelectedGroup(id, index);
      app.goTo().homePage();
    }

    Contacts contacts1 = app.db().contacts();
    ContactData contactNew = contacts1.stream().filter((c) -> c.equals(contact)).findFirst().get();
    Set<GroupData> groupsOfContact1 = contactNew.getGroups();
    assertThat(groupsOfContact1.size(), equalTo(groupsOfContact.size() - 1));

    GroupData groupData2 = groupsOfContact.stream().filter(groupData -> !(groupsOfContact1.contains(groupData)))
            .findFirst().get();
    assertThat(groupsOfContact1, equalTo(((Groups) groupsOfContact).without(groupData2)));

  }
}
