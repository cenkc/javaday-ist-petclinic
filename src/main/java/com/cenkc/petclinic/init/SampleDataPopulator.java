package com.cenkc.petclinic.init;

import com.cenkc.petclinic.model.Owner;
import com.cenkc.petclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * created by cenkc on 3/15/2019
 */
@Component
public class SampleDataPopulator {

    @Autowired
    private PetClinicService petClinicService;

    @PostConstruct
    public void init() {
        Owner owner = new Owner();
        owner.setFirstName("Cenk");
        owner.setLastName("Canarslan");
        owner.setEmail("cenk.canarslan@gmail.com");
        owner.setPassword("secret");

        petClinicService.create(owner);
    }
}
