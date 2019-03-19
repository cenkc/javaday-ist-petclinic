package com.cenkc.petclinic.service;

import com.cenkc.petclinic.model.Owner;

import java.util.List;

/**
 * created by cenkc on 3/15/2019
 */
public interface PetClinicService {
    List<Owner> getOwners();
    Owner getOwner(Long id);
    void create(Owner owner);
    void update(Owner owner);
    void delete(Long id);
}
