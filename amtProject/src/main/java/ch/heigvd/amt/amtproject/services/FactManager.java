/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : FactManager.java
 * @Description : Business layer for the facts
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;


@Stateless
public class FactManager implements FactManagerLocal {
    
    @PersistenceContext
    EntityManager em;
    

    @Override
    public Fact findFactById(long factId) {
        return em.find(Fact.class, factId);
    }

    @Override
    public List<Fact> findAllFacts() {
        return em.createNamedQuery("findAllFacts").getResultList();
    }

    @Override
    public long createFact(Fact fact) {
        em.persist(fact);
        em.flush();
        return fact.getId();
    }

    @Override
    public void updateFact(Fact fact) {
        em.merge(fact); 
    }

    @Override
    public void deleteFact(long factId) {
        em.remove(em.find(Fact.class, factId));
    }

    // Method used to find "Counter" type of facts
    @Override
    public Fact findFactBySensorAndType(Sensor sensor, String type) {
        try {
            return (Fact) em.createNamedQuery("findFactBySensorAndType").setParameter("sensor", sensor).setParameter("type", type).getSingleResult();
        }
        catch(NoResultException e) {
            return null;
        }
    }
    
    // Method used to find "Daily" type of facts
    @Override
    public Fact findFactBySensorTypeAndDate(Sensor sensor, String type, Date date) {
        try {
            return (Fact) em.createNamedQuery("findFactBySensorTypeAndDate").setParameter("sensor", sensor).setParameter("type", type).setParameter("date", date, TemporalType.DATE).getSingleResult();
        }
        catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public void deleteAll() {
       Query query = em.createNamedQuery("Fact.deleteAll");
        query.executeUpdate();
    }
}