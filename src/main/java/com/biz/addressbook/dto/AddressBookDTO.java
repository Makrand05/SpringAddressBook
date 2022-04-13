package com.biz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
     String firstName;
     String lastName;
     String city;
     String state;
     int zip;
     long phoneNumber;
     String emailId;


}
