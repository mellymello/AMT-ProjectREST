/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : OrganisationManagerLocal.java
 * @Description : Business layer for the Organisations
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Organisation;
import java.util.List;
import javax.ejb.Local;


@Local
public interface OrganisationManagerLocal {
    
    Organisation findOrganisationById(long organisationId);

    List<Organisation> findAllOrganisations();

    long createOrganisation(Organisation organisation);

    void updateOrganisation(Organisation organisation);

    void deleteOrganisation(long orgId);
    
    void deleteAll();
    
}
