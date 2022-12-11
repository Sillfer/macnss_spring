package com.simplon.cnss.service;

import com.simplon.cnss.DAO.DossierDAO;
import com.simplon.cnss.DAO.RefundableDAO;
import com.simplon.cnss.model.Dossier.Dossier;
import com.simplon.cnss.model.extras.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class DossierService {
    private RefundableDAO refundableDAO;
    private DossierDAO dossierDAO;

    public Dossier createDossier(long medicationId, Long patientId) {
        return null;
    }

    public HashMap<String, List<? extends Refundable>> getRefundables() {
        HashMap<String, List<? extends Refundable>> refundable = new HashMap<>();

        List<Medication> medications = (List<Medication>) RefundableDAO.getAll(Medication.class);
        System.out.println(medications.size());
        List<Speciality> specialities = (List<Speciality>) RefundableDAO.getAll(Speciality.class);
        System.out.println(specialities.size());
        List<Radio> radios = (List<Radio>) RefundableDAO.getAll(Radio.class);
        System.out.println(radios);
        List<Analysis> analyses = (List<Analysis>) RefundableDAO.getAll(Analysis.class);
        System.out.println(analyses);

        refundable.put("medications", medications);
        refundable.put("specialities", specialities);
        refundable.put("radios", radios);
        refundable.put("analyses", analyses);
        System.out.println(refundable);

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

