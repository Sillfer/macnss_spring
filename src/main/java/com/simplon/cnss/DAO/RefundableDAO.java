package com.simplon.cnss.DAO;

import com.simplon.cnss.model.extras.Refundable;
import com.simplon.cnss.utils.JPA;
import org.springframework.stereotype.Repository;

@Repository
public class RefundableDAO {

    public void save(Refundable refundable) {
        JPA.wrap(em -> em.persist(refundable));
    }


}
