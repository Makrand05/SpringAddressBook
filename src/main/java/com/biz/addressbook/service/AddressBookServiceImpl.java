package com.biz.addressbook.service;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.entity.ContactPerson;
import com.biz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Address book service class implementation and it implements IAddressBookService interface
 */
@Service
public class AddressBookServiceImpl implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * get all contact list from repository
     * @return list of contact person
     */
    public  List<ContactPerson> getContactPersonList() {
    return addressBookRepository.findAll();
    }

    /**
     * get the contact id and return contact data object
     * @param id contact id
     * @return contact object
     */
    @Override
    public ContactPerson getContactByID(long id) {
      return addressBookRepository.getById(id);
}

    @Override
    public ContactPerson createContactPerson(AddressBookDTO addressBookDTO) {

       return addressBookRepository.save(new ContactPerson(addressBookDTO));
    }

    @Override
    public ContactPerson updateContactPerson(int id, AddressBookDTO addressBookDTO) {
       ContactPerson contactPerson= this.getContactByID(id);
       contactPerson.updateContactPerson(addressBookDTO);
       return addressBookRepository.save(contactPerson);
    }

    @Override
    public void deleteContactByID(int id) {
        addressBookRepository.delete(this.getContactByID(id));
    }
}
