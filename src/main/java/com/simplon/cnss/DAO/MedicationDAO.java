package com.simplon.cnss.DAO;

import com.simplon.cnss.model.extras.Medication;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MedicationDAO {
    public Medication selectMedicationByBarCode(Long barCode){
        Query query = JPA.entityManager().createQuery("SELECT m FROM Medication m WHERE m.barCode = :barCode");

        query.setParameter("barCode",barCode);

        Medication medication = null;

        try{
            medication = (Medication) query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("No record found!");
        }finally {
            return medication;
        }
    }
}
