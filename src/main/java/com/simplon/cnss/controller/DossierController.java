package com.simplon.cnss.controller;


import com.simplon.cnss.DAO.DossierDAO;
import com.simplon.cnss.model.Dossier.Dossier;
import com.simplon.cnss.model.extras.Medication;
import com.simplon.cnss.service.DossierService;
import com.simplon.cnss.service.PatientService;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dossier")
public class DossierController {

    private DossierService dossierService;
    private PatientService patientService;

    @GetMapping("/new")
    public ModelAndView addDossierForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("refundables",dossierService.getRefundables());
        modelAndView.addObject("patients",patientService.getAllPatients());
        modelAndView.setViewName("agent/new_file");

        return modelAndView;
    }

    @PostMapping("/add")
    public String addDossier() {

        Medication medication = new Medication();

        medication.setId(1);
        EntityManager em = JPA.entityManager();
        Medication medication1 = em.merge(medication);

        List<Medication> medications = new ArrayList<>();
        medications.add(medication1);

        Dossier dossier = new Dossier();
        dossier.setPatientId(2L);
        dossier.setMedications(medications);

        DossierDAO dossierDAO = new DossierDAO();

        JPA.wrap(entityManager -> {
            em.persist(dossier);
        });


        return "redirect:new";

    }

    @Autowired
    public void setDossierService(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

}
