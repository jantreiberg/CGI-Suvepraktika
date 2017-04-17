package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dao.entity.DentistVisitEntity;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/allvisits").setViewName("allvisits");
        registry.addViewController("/dentists").setViewName("dentists");

    }

    @RequestMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO, Model model) {
        List<DentistVisitEntity> visits = dentistVisitService.listVisits();
        model.addAttribute("visits", visits);
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }

    @RequestMapping("allvisits")
    public String showAllVisits(Model model){
        List<DentistVisitEntity> visits = dentistVisitService.listVisits();
        model.addAttribute("visits", visits);
        return "allvisits";
    }

    @RequestMapping("dentists")
    public String showAllDentists(Model model){
        List<DentistVisitEntity> visits = dentistVisitService.listVisits();
        model.addAttribute("visits", visits);
        return "dentists";
    }

    @PostMapping("dentists")
    public String postDentist(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dentists";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/dentists";
    }

}