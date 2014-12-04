/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zak
 */
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
}
