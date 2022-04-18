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

    public  List<ContactPerson> getContactPersonList() {

        List<ContactPerson> contactPersonList= new ArrayList<>();
       // contactPersonList.add( new ContactPerson(1,new AddressBookDTO("Makrand","Shingare","Solapur","MH",413113,9096592086L,"Mak@gm.com")));
       return addressBookRepository.findAll();
     //   return contactPersonList;
    }

    @Override
    public ContactPerson getContactByID(long id) {
      return addressBookRepository.getById(id);

      //  return new ContactPerson (2,new AddressBookDTO("Makrand","Shingare","Solapur","MH",413113,9096592086L,"Mak@gm.com"));

    }

    @Override
    public ContactPerson createContactPerson(AddressBookDTO addressBookDTO) {

       return addressBookRepository.save(new ContactPerson(addressBookDTO));

    //    return new ContactPerson(1,addressBookDTO);
    }

    @Override
    public ContactPerson updateContactPerson(AddressBookDTO addressBookDTO) {
        return addressBookRepository.saveAndFlush(new ContactPerson(addressBookDTO));
        //return new ContactPerson(1,addressBookDTO);
    }

    @Override
    public void deleteContactByID(int id) {

    }
}
