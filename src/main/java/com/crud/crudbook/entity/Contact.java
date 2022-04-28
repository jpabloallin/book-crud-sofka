package com.crud.crudbook.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Contact")
@Table(name = "contact")
@Data

public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String telephone;

}
