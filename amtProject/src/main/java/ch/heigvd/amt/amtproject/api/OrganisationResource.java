/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;


import ch.heigvd.amt.amtproject.model.Organisation;
import ch.heigvd.amt.amtproject.model.User;
import ch.heigvd.amt.amtproject.services.OrganisationManagerLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Zak
 */
public class OrganisationResource {
    @EJB
    OrganisationManagerLocal organisationManager;
    
    @Context
    private UriInfo context;
    
    public OrganisationResource (){}
    
    @GET
    @Produces("application/json")
    public List<Organisation> getAllOrganisations ()
    {
        List<Organisation> result = organisationManager.findAllOrganisations();
        return result;
    }
    
    @POST
    @Consumes("application/json")
    public long createOrganisation (Organisation organisation)
    {
        long id = organisationManager.createOrganisation(organisation);
        return id;
    }
    
    @Path("{/id}")
    @GET
    @Produces("application/json")
    public Organisation getOrganisationDetails (@PathParam("id") long id)
    {
        Organisation organisation = organisationManager.findOrganisationById(id);
        return organisation;
    }
    
    @Path("{/id}")
    @PUT
    @Produces("application/json")
    public void updateOrganisation (@PathParam("id") long id, Organisation organisation)
    {
        organisationManager.createOrganisation(organisation);
    }
    
    @Path("{/id}")
    @DELETE
    @Produces("application/json")
    public void deleteOrganisation (@PathParam("id") long id)
    {
        organisationManager.deleteOrganisation(id);
    }
}
