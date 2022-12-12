package com.simplon.cnss.service;

import com.simplon.cnss.DAO.PatientDAO;
import com.simplon.cnss.model.Person.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientDAO patientDao;

    @Autowired
    public void setPatientDao(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }

    public Patient getPatientByNumber(Long patientNumber){
        return patientDao.selectPatientByNumber(patientNumber);
    }

    public Patient createPatient(String email, String password, String username, Long patientNumber){
        Patient patient = new Patient(email,username,password,patientNumber);
        patientDao.save(patient);
        return patient.getId() != null ? patient : null;
    }

    public List<Patient> getPatients(){
        return patientDao.getAll();
    }
}
