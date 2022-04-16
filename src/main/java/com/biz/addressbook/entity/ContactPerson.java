package com.biz.addressbook.entity;

import com.biz.addressbook.dto.AddressBookDTO;
import lombok.*;

@Getter
@Setter
public class ContactPerson {
    private  long id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private Integer zip;
    private Long phoneNumber;
    private String emailId;

    public ContactPerson(int id, AddressBookDTO addressBookDTO) {
        this.id=id;
        this.firstName=addressBookDTO.firstName;
        this.lastName=addressBookDTO.lastName;
        this.city= addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zip= addressBookDTO.zip;
        this.phoneNumber= addressBookDTO.phoneNumber;
        this.emailId= addressBookDTO.emailId;
    }

    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
