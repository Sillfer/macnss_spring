package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Person.Agent;
import org.springframework.stereotype.Repository;

@Repository
public class AgentDAO extends PersonDAO {

    public Agent selectByEmailAndPassword(String email, String password){
        return (Agent) super.selectByEmailAndPassword(email,password,Agent.class);
    }
}
