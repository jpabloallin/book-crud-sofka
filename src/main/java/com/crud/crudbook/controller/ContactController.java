package com.crud.crudbook.controller;

import com.crud.crudbook.entity.Contact;
import com.crud.crudbook.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/")

public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("get/contacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @PostMapping("save/contact")
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @PutMapping("update/contact/{id}")
    public ResponseEntity<Contact> updateContact (@RequestBody Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactService.updateContact(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping("delete/contact/{id}")
    public void deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
    }

    @PatchMapping(path = "update/contact/name/{id}")
    public ResponseEntity<Contact> updateName (Contact contact, @PathVariable("id") Long id) {
        log.info("Nombre del contacto a modificar: {}", contact);
        contactService.updateName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }


    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact>  updateEmail (Contact contact, @PathVariable("id") Long id) {
        log.info("Email del contacto a modificar: {}", contact);
        contactService.updateEmail(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/telephone/{id}")
    public ResponseEntity<Contact>  updateTelephone (Contact contact, @PathVariable("id") Long id) {
        log.info("Teléfono del contacto a modificar: {}", contact);
        contactService.updateTelephone(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
