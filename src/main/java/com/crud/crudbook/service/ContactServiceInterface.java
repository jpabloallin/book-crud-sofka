package com.crud.crudbook.service;

import com.crud.crudbook.entity.Contact;

import java.util.List;

public interface ContactServiceInterface {

    List<Contact> getAllContacts();

    Contact saveContact(Contact contact);

    Contact updateContact(Long id, Contact contact);

    void deleteContact(Long id);
}
