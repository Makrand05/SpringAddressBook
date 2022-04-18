package com.biz.addressbook.repository;

import com.biz.addressbook.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<ContactPerson,Long>{
}
