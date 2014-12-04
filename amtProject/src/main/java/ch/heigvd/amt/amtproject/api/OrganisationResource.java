/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;


import ch.heigvd.amt.amtproject.dto.OrganisationDTO;
import ch.heigvd.amt.amtproject.model.Organisation;
import ch.heigvd.amt.amtproject.services.OrganisationManagerLocal;
import java.util.LinkedList;
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
    public List<OrganisationDTO> getAllOrganisations ()
    {
        List<Organisation> organisations = organisationManager.findAllOrganisations();
        List<OrganisationDTO> result = new LinkedList<>();
        
        for(Organisation organisation : organisations)
        {
            result.add(toDTO(organisation));
        }
        return result;
    }
    
    @Path("{/id}")
    @GET
    @Produces("application/json")
    public OrganisationDTO getOrganisationDetails (@PathParam("id") long id)
    {
        Organisation organisation = organisationManager.findOrganisationById(id);
        return toDTO(organisation);
    }
    
    @POST
    @Consumes("application/json")
    public long createOrganisation (OrganisationDTO organisationDTO)
    {
        Organisation newOrganisation = new Organisation();
        long id = organisationManager.createOrganisation(toOrganisation(organisationDTO,newOrganisation));
        return id;
    }
    
    @Path("{/id}")
    @PUT
    @Produces("application/json")
    public void updateOrganisation (@PathParam("id") long id, OrganisationDTO dto)
    {
        Organisation existing = organisationManager.findOrganisationById(id);
        organisationManager.updateOrganisation(toOrganisation(dto, existing));
    }
    
    @Path("{/id}")
    @DELETE
    @Produces("application/json")
    public void deleteOrganisation (@PathParam("id") long id)
    {
        organisationManager.deleteOrganisation(id);
    }
    
    private OrganisationDTO toDTO(Organisation organisation) {
        OrganisationDTO organisationDTO = new OrganisationDTO();
        organisationDTO.setId(organisation.getId());
        organisationDTO.setName(organisation.getName());
        organisationDTO.setContactUser(organisation.getContactUser());
        organisationDTO.setSensors(organisation.getSensors());
        organisationDTO.setUsers(organisation.getUsers());
        organisationDTO.setFacts(organisation.getFacts());
        return organisationDTO;
    }

    private Organisation toOrganisation(OrganisationDTO organisationDTO, Organisation original) {
        original.setName(organisationDTO.getName());
        original.setContactUser(organisationDTO.getContactUser());
        original.setSensors(organisationDTO.getSensors());
        original.setUsers(organisationDTO.getUsers());
        original.setFacts(organisationDTO.getFacts());
        return original;
    }
}
