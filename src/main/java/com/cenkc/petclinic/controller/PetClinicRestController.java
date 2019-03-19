package com.cenkc.petclinic.controller;

import com.cenkc.petclinic.exception.OwnerNotFoundException;
import com.cenkc.petclinic.model.Owner;
import com.cenkc.petclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by cenkc on 3/15/2019
 */
@RestController
@RequestMapping(value = "/rest")
public class PetClinicRestController {

    @Autowired
    private PetClinicService petClinicService;

    @PostMapping(value = "/owner")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long createOwner(@RequestBody Owner owner) {
        petClinicService.create(owner);
        return owner.getId();
    }

    @PutMapping("/owner/{id}")
    public void createOrUpdate(Owner owner, @PathVariable Long id) {
        Owner ownerFromDb = petClinicService.getOwner(id);
        if (ownerFromDb == null) {
            petClinicService.create(owner);
        } else {
            ownerFromDb.setFirstName(owner.getFirstName());
            ownerFromDb.setLastName(owner.getLastName());
            ownerFromDb.setEmail(owner.getEmail());
            petClinicService.update(ownerFromDb);
        }

    }

    @DeleteMapping("/owner/{id}")
    public void Delete(@PathVariable Long id) {
        petClinicService.delete(id);
    }

    @GetMapping(value = "/owners")
    public List<Owner> getOwners() {
        return petClinicService.getOwners();
    }

    @GetMapping(value = "/owner/{id}")
    public Owner getOwner(@PathVariable("id") Long id) {
        Owner owner = petClinicService.getOwner(id);
        if (owner == null) {
            throw new OwnerNotFoundException();
        }
        return owner;
    }
}
