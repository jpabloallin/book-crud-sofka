package com.crud.crudbook.service;

import com.crud.crudbook.entity.Contact;
import com.crud.crudbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService implements ContactServiceInterface {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @Transactional
    public void updateName(Long id, Contact contact) {
        contactRepository.updateName(id, contact.getName());
    }

    @Transactional
    public void updateEmail(Long id, Contact contact) {
        contactRepository.updateEmail(id, contact.getEmail());
    }

    @Transactional
    public void updateTelephone(Long id, Contact contact) {
        contactRepository.updateTelephone(id, contact.getTelephone());
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
