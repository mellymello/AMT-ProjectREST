/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;


import ch.heigvd.amt.amtproject.model.Observation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zak
 */
@Stateless
public class ObservationManager implements ObservationManagerLocal {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public Observation findObservationById(long observationId) {
        return em.find(Observation.class, observationId);
    }

    @Override
    public List<Observation> findAllObservations() {
        return em.createNamedQuery("findAllObservations").getResultList();
    }

    @Override
    public long createObservation(Observation observation) {
        em.persist(observation);
        em.flush();
        return observation.getId();
    }

    @Override
    public void updateObservation(Observation observation) {
        em.merge(observation); 
    }

    @Override
    public void deleteObservation(long observationId) {
        em.remove(em.find(Observation.class, observationId));
    }
}
