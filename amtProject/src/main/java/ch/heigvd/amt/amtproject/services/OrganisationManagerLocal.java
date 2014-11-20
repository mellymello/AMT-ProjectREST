/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Organisation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Zak
 */
@Local
public interface OrganisationManagerLocal {
    
    Organisation findOrganisationById(long userId);

    List<Organisation> findAllOrganisations();

    long createOrganisation(Organisation organisation);

    void updateOrganisation(Organisation organisation);

    void deleteOrganisation(long userId);
    
}
