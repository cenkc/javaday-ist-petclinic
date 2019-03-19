package com.cenkc.petclinic.dao;

import com.cenkc.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by cenkc on 3/15/2019
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByEmail(String email);
}
