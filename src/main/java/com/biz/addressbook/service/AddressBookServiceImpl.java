package com.biz.addressbook.service;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.entity.ContactPerson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Address book service class implementation and it implements IAddressBookService interface
 */
@Service
public class AddressBookServiceImpl implements IAddressBookService {
    @Override
    public  List<ContactPerson> getContactPersonList() {

        List<ContactPerson> contactPersonList= new ArrayList<>();
        contactPersonList.add( new ContactPerson(1,new AddressBookDTO("Makrand","Shingare","Solapur","MH",413113,9096592086L,"Mak@gm.com")));
        return contactPersonList;
    }

    @Override
    public ContactPerson getContactByID(int id) {
        return new ContactPerson (2,new AddressBookDTO("Makrand","Shingare","Solapur","MH",413113,9096592086L,"Mak@gm.com"));

    }

    @Override
    public ContactPerson createContactPerson(AddressBookDTO addressBookDTO) {
        return new ContactPerson(1,addressBookDTO);
    }

    @Override
    public ContactPerson updateContactPerson(AddressBookDTO addressBookDTO) {
        return new ContactPerson(1,addressBookDTO);
    }

    @Override
    public void deleteContactByID(int id) {

    }
}
