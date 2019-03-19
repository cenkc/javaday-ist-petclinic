package com.cenkc.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * created by cenkc on 3/15/2019
 */
@Entity
public class Pet {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
