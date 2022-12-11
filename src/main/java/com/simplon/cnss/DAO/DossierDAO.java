package com.simplon.cnss.DAO;

import com.simplon.cnss.model.Dossier.Dossier;
import com.simplon.cnss.utils.JPA;
import org.springframework.stereotype.Repository;

import java.io.File;

@Repository
public class DossierDAO {

        public void save(Dossier dossier){
            JPA.wrap(entityManager -> entityManager.persist(dossier));
        }
}
