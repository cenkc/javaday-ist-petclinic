package com.cenkc.petclinic.service;

import com.cenkc.petclinic.dao.OwnerRepository;
import com.cenkc.petclinic.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * created by cenkc on 3/19/2019
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Owner owner = ownerRepository.findByEmail(username);
        if (owner == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return owner;
    }
}
