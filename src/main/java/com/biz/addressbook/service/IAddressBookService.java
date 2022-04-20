package com.biz.addressbook.service;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.entity.ContactPerson;

import java.util.List;

public interface IAddressBookService {

    List<ContactPerson> getContactPersonList();

    ContactPerson getContactByID(long id);

    ContactPerson createContactPerson(AddressBookDTO addressBookDTO);

    ContactPerson updateContactPerson(int id, AddressBookDTO addressBookDTO);

    void deleteContactByID(long id);

    ContactPerson getData(String name,String pass);
}
