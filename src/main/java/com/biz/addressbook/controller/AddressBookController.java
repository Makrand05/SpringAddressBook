package com.biz.addressbook.controller;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.dto.ResponseDTO;
import com.biz.addressbook.entity.ContactPerson;
import com.biz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;

    /**
     * get the all data from JSON object
     *
     * @return data and status for get request
     */
    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAddressBook() {
        List<ContactPerson> contactPersonList = iAddressBookService.getContactPersonList();
        ResponseDTO responseDTO = new ResponseDTO("Get Mapping success", contactPersonList);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
    /**
     * get the contact by using id
     *
     * @param id of the contact
     * @return data with status
     */
    @GetMapping("/getbyid/{contactId}")
    public ResponseEntity<ResponseDTO> getContactByID(@PathVariable("contactId") long id) {

        ContactPerson contactPerson = iAddressBookService.getContactByID(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call by Id success" + id, contactPerson);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * created a new contact
     *
     * @param addressBookDTO get the dta inform of JSON from user
     * @return data with status
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createContact(@RequestBody AddressBookDTO addressBookDTO) {
        ContactPerson contactPerson = iAddressBookService.createContactPerson(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created new contact in address book", contactPerson);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * Update a new contact
     *
     * @param addressBookDTO get the data inform of JSON from user
     * @return data with status
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable("id") int id, @RequestBody AddressBookDTO addressBookDTO) {
        ContactPerson contactPerson = iAddressBookService.updateContactPerson(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated new contact in address book", contactPerson);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    /**
     * delete a new contact
     *
     * @param id delete contact for given id
     * @return data with status
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("id") long id) {
        iAddressBookService.deleteContactByID(id);
        return new ResponseEntity("Address Book with ID " + id + " is Deleted", HttpStatus.OK);
    }

    /**
     * Register a new user
     *
     * @param addressBookDTO
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody AddressBookDTO addressBookDTO) {

        ContactPerson contactPerson = iAddressBookService.createContactPerson(addressBookDTO);
        if (contactPerson != null) {
            ResponseDTO responseDTO = new ResponseDTO("Registered new user in address book", contactPerson);
            return new ResponseEntity(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity("Email id already present", HttpStatus.OK);
        }
    }

    /**
     * login API using username and password
     *
     * @param
     * @param
     */
    @PostMapping(value = "/login")
    public ResponseEntity<ResponseDTO> loginAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO responseDTO;
        boolean status = iAddressBookService.getData(addressBookDTO.emailId, addressBookDTO.password);
        if (status) {
            return new ResponseEntity(" User login Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity("Invalid Username and password", HttpStatus.OK);
        }
    }
}
