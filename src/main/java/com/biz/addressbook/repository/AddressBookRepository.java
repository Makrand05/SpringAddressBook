package com.biz.addressbook.repository;

import com.biz.addressbook.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressBookRepository extends JpaRepository<ContactPerson,Long>{


    @Query(value = "select * from address_book where first_name = :name and password= :pass",nativeQuery = true)
    ContactPerson findDataByNameAndPassword(String name, String pass);
}
