package com.cenkc.petclinic.dao;

import com.cenkc.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by cenkc on 3/15/2019
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
