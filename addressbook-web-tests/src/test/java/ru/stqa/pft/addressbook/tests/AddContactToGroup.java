package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddContactToGroup extends TestBase {

  @Test
  public void testAddContactToGroup() {
    Groups group = app.db().groups();
    Contacts contacts = app.db().contacts();
    ContactData contact = contacts.iterator().next();
    int id = contact.getId();
    Set<GroupData> groupOfContactSet = contact.getGroups();

    if (groupOfContactSet.size() < group.size()) {
      group.removeAll(groupOfContactSet);
      int index = group.iterator().next().getId();
      app.contact().addInSelectGroup(id, index);
      app.goTo().homePage();

    } else {
      GroupData newGroup = new GroupData();
      app.goTo().groupPage();
      long now = System.currentTimeMillis();
      app.group().create(newGroup.withName(String.format("newGroup%s", now)));
      int index = app.db().groups().stream().mapToInt(g -> g.getId()).max().getAsInt();
      app.goTo().homePage();
      app.contact().addInSelectGroup(id, index);
      app.goTo().homePage();
    }

    Contacts contacts1 = app.db().contacts();
    ContactData contactnew = contacts1.stream().filter((c) -> c.equals(contact)).findFirst().get();
    Set<GroupData> groupOfContactSet1 = contactnew.getGroups();
    assertThat(groupOfContactSet1.size(), equalTo(groupOfContactSet.size() + 1));

    GroupData groupData1 = groupOfContactSet1.stream().filter(groupData -> !(groupOfContactSet.contains(groupData))).findFirst().get();
    groupOfContactSet.add(groupData1);
    assertThat(groupOfContactSet1, equalTo(((Groups) groupOfContactSet).withAdded(groupData1)));
  }
}

