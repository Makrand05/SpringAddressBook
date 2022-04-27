package com.biz.addressbook.service;

import com.biz.addressbook.dto.AddressBookDTO;
import com.biz.addressbook.dto.LoginDTO;
import com.biz.addressbook.entity.ContactPerson;
import com.biz.addressbook.exception.AddressableException;
import com.biz.addressbook.repository.AddressBookRepository;
import com.biz.addressbook.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Address book service class implementation and it implements IAddressBookService interface
 */
@Service
public class AddressBookServiceImpl implements IAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    TokenGenerator tokenGenerator = new TokenGenerator();
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
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressableException("Employee not found with id :" + id));
    }

    /**
     * Create new contact person
     * @param addressBookDTO
     * @return
     */
    @Override
    public ContactPerson createContactPerson(AddressBookDTO addressBookDTO) {

        int count = addressBookRepository.findEmailId(addressBookDTO.getEmailId());
        if (count == 0) {
            addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
            return addressBookRepository.save(new ContactPerson(addressBookDTO));
        } else {
            return null;
        }
    }

    /**
     * Update contect person by ID
     * @param id
     * @param addressBookDTO
     * @return
     */
    @Override
    public ContactPerson updateContactPerson(int id, AddressBookDTO addressBookDTO) {
        addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
        ContactPerson contactPerson = this.getContactByID(id);
        contactPerson.updateContactPerson(addressBookDTO);
        return addressBookRepository.save(contactPerson);
    }

    /**
     * Delect contact person by ID
     * @param id
     */
    @Override
    public void deleteContactByID(long id) {
        ContactPerson contactPerson = this.getContactByID(id);
        addressBookRepository.delete(contactPerson);
    }


    @Override
    public String loginUser(LoginDTO loginDTO) {

        String password = addressBookRepository.findPassword(loginDTO.getEmailId());
        boolean status = passwordEncoder.matches(loginDTO.getPassword(), password);

        Optional<ContactPerson> user=addressBookRepository.findByEmailId(loginDTO.getEmailId());

        String token = tokenGenerator.createToken(user.get().getId());

        if (status) {
            return " User login Successfully\n"+token;
        } else {
            return "Invalid Username and password";
        }
    }

    @Override
    public boolean encodePassword(String password) {
        return false;
    }
}
