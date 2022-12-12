package com.simplon.cnss.service;

import com.simplon.cnss.DAO.AgentDAO;
import com.simplon.cnss.DAO.PatientDAO;
import com.simplon.cnss.model.Person.Person;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private AgentDAO agentDAO;

    private PatientDAO patientDAO;

    public Person authenticate(String email,String password,String role){
        Person person = null;
        if(role.equals("agent")){
            person = agentDAO.selectByEmailAndPassword(email,password);
        } else if (role.equals("patient")) {
            person = patientDAO.selectByEmailAndPassword(email,password);
        }
        return person;
    }

    @Autowired
    public void setAgentDao(AgentDAO agentDao) {
        this.agentDAO = agentDao;
    }

    @Autowired
    public void setPatientDao(PatientDAO patientDao) {
        this.patientDAO = patientDao;
    }}
