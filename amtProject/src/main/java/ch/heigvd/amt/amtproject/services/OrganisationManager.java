/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Organisation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zak
 */
@Stateless
public class OrganisationManager implements OrganisationManagerLocal {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public Organisation findOrganisationById(long organisationId) {
        return em.find(Organisation.class, organisationId);
    }

    @Override
    public List<Organisation> findAllOrganisations() {
        return em.createNamedQuery("findAllOrganisations").getResultList();
    }

    @Override
    public long createOrganisation(Organisation organisation) {
        em.persist(organisation);
        em.flush();
        return organisation.getId();
    }

    @Override
    public void updateOrganisation(Organisation organisation) {
        em.merge(organisation);
    }

    @Override
    public void deleteOrganisation(long organisationId) {
        em.remove(em.find(Organisation.class, organisationId));
    }

    
}
