package com.simplon.cnss.DAO;

import com.simplon.cnss.model.extras.Refundable;
import com.simplon.cnss.utils.JPA;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RefundableDAO {

    public List<? extends Refundable> getAll(Class clazz) {
        Query query = JPA.entityManager().createQuery("SELECT r FROM " + clazz.getSimpleName() + " r");

        return query.getResultList();

    }
}
