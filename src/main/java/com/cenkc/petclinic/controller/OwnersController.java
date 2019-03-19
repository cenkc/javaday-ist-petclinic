package com.cenkc.petclinic.controller;

import com.cenkc.petclinic.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by cenkc on 3/15/2019
 */
@Controller
public class OwnersController {

    @Autowired
    private PetClinicService petClinicService;

    public String displayIndex() {
        return "redirect:/owners";
    }

    @GetMapping("/owners")
    public ModelAndView displayOwnersPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/WEB-INF/jsp/owners.jsp");
        mav.addObject("owners", petClinicService.getOwners());
        return mav;
    }
}
