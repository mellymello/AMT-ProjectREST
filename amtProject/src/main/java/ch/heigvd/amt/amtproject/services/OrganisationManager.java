/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : OrganisationManager.java
 * @Description : Business layer for the Organisations
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Organisation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


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
