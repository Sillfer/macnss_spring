package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Person.Person;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;

import java.util.List;

@Repository
public class PersonDAO {

    public List<? extends Person> getAll(Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p");
        return query.getResultList();
    }

    public Person selectByEmailAndPassword(String email, String password, Class clazz){
        Query query = JPA.entityManager().createQuery("SELECT p FROM "+clazz.getSimpleName()+" p WHERE p.email = :email");

        query.setParameter("email",email);

        Person person = null;

        try{
            person = (Person) query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No record found!");
        }

        if (person == null || !person.getPassword().equals(password)) {
            return null;
        }

        return person;
    }

    public void save(Person person){
        JPA.wrap(entityManager -> entityManager.persist(person));
    }
}
