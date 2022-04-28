package com.crud.crudbook.repository;

import com.crud.crudbook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {

    @Modifying
    @Query("update Contact cont set cont.name = :name where cont.id = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );

    @Modifying
    @Query("update Contact cont set cont.email = :email where cont.id = :id")
    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );

    @Modifying
    @Query("update Contact cont set cont.telephone = :telephone where cont.id = :id")
    public void updateTelephone(
            @Param(value = "id") Long id,
            @Param(value = "telephone") String telephone
    );

}
