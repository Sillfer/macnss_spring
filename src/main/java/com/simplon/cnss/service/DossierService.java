package com.simplon.cnss.service;

import com.simplon.cnss.DAO.DossierDAO;
import com.simplon.cnss.DAO.RefundableDAO;
import com.simplon.cnss.model.Dossier.Dossier;
import com.simplon.cnss.model.Person.Patient;
import com.simplon.cnss.model.extras.*;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DossierService {
    private RefundableDAO refundableDAO;
    private DossierDAO dossierDAO;

    public Dossier createDossier(List<Long> specialityIds, List<Long> analysisIds,
                                 List<Long> radioIds, List<Long> medicationIds, Long patientId) {
        EntityManager em = JPA.entityManager();

        List<Speciality> specialities = new ArrayList<>();
        List<Medication> medications = new ArrayList<>();
        List<Analysis> analyses = new ArrayList<>();
        List<Radio> radios = new ArrayList<>();

        for(Long id: specialityIds){
            Speciality speciality = em.find(Speciality.class,id);
            specialities.add(speciality);
        }

        for(Long id: medicationIds){
            Medication medication = em.find(Medication.class,id);
            medications.add(medication);
        }

        for(Long id: analysisIds){
            Analysis analysis = em.find(Analysis.class,id);
            analyses.add(analysis);
        }

        for(Long id: radioIds){
            Radio radio = em.find(Radio.class,id);
            radios.add(radio);
        }




        Dossier dossier = new Dossier();
        dossier.setPatientId(patientId);
        dossier.setMedications(medications);
        dossier.setAnalyses(analyses);
        dossier.setRadios(radios);
        dossier.setSpecialities(specialities);

        dossierDAO.save(em,dossier);

        return null;

    }

    public HashMap<String, List<? extends Refundable>> getRefundables() {
        HashMap<String, List<? extends Refundable>> refundable = new HashMap<>();

        List<Medication> medications =  (List<Medication>) refundableDAO.getAll(Medication.class);
        List<Speciality> specialities = (List<Speciality>) refundableDAO.getAll(Speciality.class);
        List<Radio> radios = (List<Radio>) refundableDAO.getAll(Radio.class);
        List<Analysis> analyses = (List<Analysis>) refundableDAO.getAll(Analysis.class);

        refundable.put("medications", medications);
        refundable.put("specialities", specialities);
        refundable.put("radios", radios);
        refundable.put("analyses", analyses);

        return refundable;
    }

    @Autowired
    public void setRefundableDao(RefundableDAO refundableDao) {
        this.refundableDAO = refundableDao;
    }

    @Autowired
    public void setDossierDao(DossierDAO dossierDao) {
        this.dossierDAO = dossierDao;
    }

}

