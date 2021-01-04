package com.ldap.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Data
@Entry(base="ou=users", objectClasses = {
        "top",
        "inetOrgPerson", "person", "organizationalPerson"})
public class Person {

    @JsonIgnore
    @Id
    private Name id;

    @JsonProperty("userName")
    @Attribute(name = "uid")
    private  String uid;

    @JsonProperty("firstName")
    private @Attribute(name = "cn") String firstName;


    @JsonIgnore
    private @Attribute(name = "displayname") String displayName;

    @JsonProperty("lastName")
    private  @Attribute(name = "sn") String lastName;



    public Person(String uid, String firstName, String displayName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.displayName = displayName;
        this.lastName = lastName;
    }

    public Person(String userName, String firstName, String lastName) {
        this.uid = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUid() {
        return uid;
    }



    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}