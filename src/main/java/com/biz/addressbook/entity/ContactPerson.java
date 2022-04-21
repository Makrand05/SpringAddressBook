package com.biz.addressbook.entity;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.service.AddressBookServiceImpl;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Address_Book")               //Table name in database
public @Data class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private Integer zip;
    private Long phoneNumber;
    private String emailId;
    public String password;

    public ContactPerson(AddressBookDTO addressBookDTO) {
        this.updateContactPerson(addressBookDTO);

    }

    public void updateContactPerson(AddressBookDTO addressBookDTO) {
        this.firstName=addressBookDTO.firstName;
        this.lastName=addressBookDTO.lastName;
        this.city= addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.zip= addressBookDTO.zip;
        this.phoneNumber= addressBookDTO.phoneNumber;
        this.emailId= addressBookDTO.emailId;
        this.password= addressBookDTO.password;

    }

    public ContactPerson() {

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
                ", password='" + password + '\'' +
                '}';
    }
}
