package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Person.Patient;
import com.simplon.cnss.utils.JPA;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAO extends PersonDAO {

    public Patient selectByEMailAndPassword(String email, String password) {
        return (Patient) super.selectByEMailAndPassword(email, password, Patient.class);

    }

    public List<Patient> getAll(){
        return (List<Patient>) super.getAll(Patient.class);
    }
}
