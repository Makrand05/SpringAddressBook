package com.biz.addressbook.repository;

import com.biz.addressbook.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressBookRepository extends JpaRepository<ContactPerson,Long>{
}
