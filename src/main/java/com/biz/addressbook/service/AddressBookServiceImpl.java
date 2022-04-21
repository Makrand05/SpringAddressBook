package com.biz.addressbook.service;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.entity.ContactPerson;
import com.biz.addressbook.exception.AddressbookException;
import com.biz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Address book service class implementation and it implements IAddressBookService interface
 */
@Service
public class AddressBookServiceImpl implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    /**
     * get all contact list from repository
     *
     * @return list of contact person
     */
    public List<ContactPerson> getContactPersonList() {
        return addressBookRepository.findAll();
    }

    /**
     * get the contact id and return contact data object
     *
     * @param id contact id
     * @return contact object
     */
    @Override
    public ContactPerson getContactByID(long id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressbookException("Employee not found with id :" + id));
    }

    @Override
    public ContactPerson createContactPerson(AddressBookDTO addressBookDTO) {

        int count = addressBookRepository.findEmailId(addressBookDTO.getEmailId());
        if(count==0){
            addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
            return addressBookRepository.save(new ContactPerson(addressBookDTO));
        }else {
            return null;
        }


    }

    @Override
    public ContactPerson updateContactPerson(int id, AddressBookDTO addressBookDTO) {
        addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
        ContactPerson contactPerson = this.getContactByID(id);
        contactPerson.updateContactPerson(addressBookDTO);
        return addressBookRepository.save(contactPerson);
    }

    @Override
    public void deleteContactByID(long id) {
        ContactPerson contactPerson = this.getContactByID(id);
        addressBookRepository.delete(contactPerson);
    }

    @Override
    public boolean getData(String email, String pass) {

        String password= addressBookRepository.findPassword(email);
       return passwordEncoder.matches(pass,password);
    }

    @Override
    public boolean encodePassword(String password) {
        return false;
    }
}
