package com.simplon.cnss.service;

import com.simplon.cnss.DAO.PatientDAO;
import com.simplon.cnss.model.Person.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private PatientDAO patientDAO;

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public Patient createPatient(String email, String username, String password, long patientNumber) {
        Patient patient = new Patient(email, username, password, patientNumber);
        patientDAO.save(patient);
        return patient.getId() > 0 ? patient : null; // if id is greater than 0, then the patient is saved
    }
}
