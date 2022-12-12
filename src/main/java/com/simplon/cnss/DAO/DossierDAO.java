package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Dossier.Dossier;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class DossierDAO {

    public void save(Dossier dossier) {
        JPA.wrap(entityManager -> entityManager.persist(dossier));
    }

    public void save(EntityManager em, Dossier dossier) {
        JPA.wrap(em, entityManager -> entityManager.persist(dossier));
    }
}
