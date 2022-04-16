package com.biz.addressbook.dto;

import com.biz.addressbook.entity.ContactPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@AllArgsConstructor
public class AddressBookDTO {

    //Validate first name
    @NotEmpty(message = "First name should not be empty")

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Please enter valid name")
    public String firstName;

//    Validate last name
    @NotEmpty(message = "First name should not be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Please enter valid last name")
    public String lastName;

    @NotEmpty(message = "City name should not be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Please enter valid last name")
    public String city;

//    validation for stae name
    @NotEmpty(message = "State name should not be empty")
    public String state;

//    validation for zip code
    @NotEmpty(message = "Zip name should not be empty")
    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$",message = "Zip should be valid")
    public int zip;

//    validation for the Mobile number
    @Pattern(regexp = "^([0-9]{2}\\s)?[0-9]{10}$",message = "Mobile number should be valid")
    public long phoneNumber;

//    Validate email id
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9]{3,}([-._+][a-zA-Z0-9]+)?@[a-z]{2,}.[a-z]{2,3}(.[a-z]{2})?$"
            ,message = "Email shuld be a valid (e.g. xxx@yyy.zzz)")
    public String emailId;

    @Override
    public String toString() {
        return "AddressBookDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
