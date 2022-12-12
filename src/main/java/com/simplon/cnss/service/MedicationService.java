package com.simplon.cnss.service;

import com.simplon.cnss.DAO.MedicationDAO;
import com.simplon.cnss.model.extras.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    private MedicationDAO medicationDao;

    public Medication getMedicationByBarCode(Long barCode){
        return medicationDao.selectMedicationByBarCode(barCode);
    }

    @Autowired
    public void setMedicationDao(MedicationDAO medicationDao) {
        this.medicationDao = medicationDao;
    }
}
