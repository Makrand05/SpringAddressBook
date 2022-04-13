package com.biz.addressbook.entity;

import com.biz.addressbook.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.city= addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip= addressBookDTO.getZip();
        this.phoneNumber= addressBookDTO.getPhoneNumber();
        this.emailId= addressBookDTO.getEmailId();
    }

}
