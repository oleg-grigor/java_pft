package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String telHome;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String telMobile;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String telWork;

  @Transient
  private String allPhones;

  @Transient
  private String allAddress;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;

  @Column(name = "photo")
  @Type(type = "text")
  @Transient
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public Groups getGroups() {
    return new Groups(groups);
  }

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return new File (photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllAddress() {
    return allAddress;
  }

  public ContactData withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withTelHome(String home) {
    this.telHome = home;
    return this;
  }

  public ContactData withTelMobile(String mobile) {
    this.telMobile = mobile;
    return this;
  }

  public ContactData withTelWork(String work) {
    this.telWork = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getTelHome() {
    return telHome;
  }

  public String getTelMobile() {
    return telMobile;
  }

  public String getTelWork() {
    return telWork;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(address, that.address) &&
            Objects.equals(telHome, that.telHome) &&
            Objects.equals(telMobile, that.telMobile) &&
            Objects.equals(telWork, that.telWork) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, address, telHome, telMobile, telWork, email, email2, email3);
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }

  public ContactData removeOfGroup(GroupData group) {
    groups.remove(group);
    return this;
  }
}
