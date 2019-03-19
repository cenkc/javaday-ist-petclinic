package com.cenkc.petclinic.service;

import com.cenkc.petclinic.dao.OwnerRepository;
import com.cenkc.petclinic.dao.PetRepository;
import com.cenkc.petclinic.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * created by cenkc on 3/15/2019
 */
@Service
@Transactional
public class PetClinicServiceImpl implements PetClinicService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwner(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Owner owner) {
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        ownerRepository.save(owner);
        //petRepository.save(pet);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }
}
