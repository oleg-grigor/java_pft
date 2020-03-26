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

public class AddContactToGroupTests extends TestBase {

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
  }

  @Test
  public void testAddContactToGroup() {
    Groups group = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int id = contact.getId();
    Set<GroupData> groupsOfContact = contact.getGroups();

    if (groupsOfContact.size() < group.size()) {
      group.removeAll(groupsOfContact);
      int index = group.iterator().next().getId();
      app.contact().addInSelectedGroup(id, index);

    } else {
      GroupData newGroup = new GroupData();
      app.goTo().groupPage();
      long now = System.currentTimeMillis();
      app.group().create(newGroup.withName(String.format("TEST", now)));
      int index = app.db().groups().stream().mapToInt(g -> g.getId()).max().getAsInt();
      app.goTo().homePage();
      app.contact().addInSelectedGroup(id, index);
    }
    app.goTo().homePage();

    Contacts contacts1 = app.db().contacts();
    ContactData contactNew = contacts1.stream().filter((c) -> c.equals(contact)).findFirst().get();
    Set<GroupData> groupOfContactSet1 = contactNew.getGroups();
    assertThat(groupOfContactSet1.size(), equalTo(groupsOfContact.size() + 1));

    GroupData groupData1 = groupOfContactSet1.stream().filter(groupData -> !(groupsOfContact.contains(groupData)))
            .findFirst().get();
    groupsOfContact.add(groupData1);
    assertThat(groupOfContactSet1, equalTo(((Groups) groupsOfContact).withAdded(groupData1)));
  }
}

