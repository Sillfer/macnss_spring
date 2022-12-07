package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Person.Person;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;

@Repository
public class PersonDAO {

    public void save(Person person) {
        JPA.wrap(em -> em.persist(person));
    }

    public Person selectByEMailAndPassword(String email, String password, Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT p FROM " + clazz.getSimpleName() + " p WHERE p.email = :email");

        query.setParameter("email", email);

        Person person = null;

        try {
            person = (Person) query.getSingleResult(); // throws NoResultException if no result found
        } catch (NoResultException e) {
            System.out.println("No record found!");
        }

        if (person == null || !person.getPassword().equals(password)) { // if no record found or password is wrong
            return null;
        }

        return person;
    }
}