package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Person.Agent;
import org.springframework.stereotype.Repository;

@Repository
public class AgentDAO extends PersonDAO {

    public Agent selectByEMailAndPassword(String email, String password) {
        return (Agent) super.selectByEMailAndPassword(email, password, Agent.class);
    }
}
