/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;


import ch.heigvd.amt.amtproject.dto.OrganisationDTO;
import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Organisation;
import ch.heigvd.amt.amtproject.model.Sensor;
import ch.heigvd.amt.amtproject.model.User;
import ch.heigvd.amt.amtproject.services.FactManagerLocal;
import ch.heigvd.amt.amtproject.services.OrganisationManagerLocal;
import ch.heigvd.amt.amtproject.services.SensorManagerLocal;
import ch.heigvd.amt.amtproject.services.UserManagerLocal;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

@Path("organisations")
@Stateless
public class OrganisationResource {
    @EJB
    OrganisationManagerLocal organisationManager;
    
    @EJB
    SensorManagerLocal sensorManager;
    
    @EJB
    UserManagerLocal userManager;
    
    @EJB
    FactManagerLocal factManager;
    
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
    
    @Path("/{id}")
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
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public void updateOrganisation (@PathParam("id") long id, OrganisationDTO dto)
    {
        Organisation existing = organisationManager.findOrganisationById(id);
        organisationManager.updateOrganisation(toOrganisation(dto, existing));
    }
    
    @Path("/{id}")
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
        
        Collection<Sensor> sensors = organisation.getSensors();
        Collection<Long> sensorsId = new LinkedList<Long>();
        for (Sensor sensor : sensors) {
            sensorsId.add(sensor.getId());
        }
        organisationDTO.setSensors(sensorsId);
        
        Collection<User> users = organisation.getUsers();
        Collection<Long> usersId = new LinkedList<Long>();
        for (User user : users) {
            usersId.add(user.getId());
        }
        organisationDTO.setUsers(usersId);
        
        Collection<Fact> facts = organisation.getFacts();
        Collection<Long> factsId = new LinkedList<Long>();
        for (Fact fact : facts) {
            factsId.add(fact.getId());
        }
        organisationDTO.setFacts(factsId);
        
        return organisationDTO;
    }

    private Organisation toOrganisation(OrganisationDTO organisationDTO, Organisation original) {
        original.setName(organisationDTO.getName());
        original.setContactUser(organisationDTO.getContactUser());
        
        Collection<Long> sensorsId = organisationDTO.getSensors();
        Collection<Sensor> sensors = new LinkedList<Sensor>();
        for (Long sensorId: sensorsId) {
            sensors.add(sensorManager.findSensorById(sensorId));
        }
        original.setSensors(sensors);
        
        Collection<Long> usersId = organisationDTO.getUsers();
        Collection<User> users = new LinkedList<User>();
        for (Long userId: usersId) {
            users.add(userManager.findUserById(userId));
        }
        original.setUsers(users);
        
        Collection<Long> factsId = organisationDTO.getFacts();
        Collection<Fact> facts = new LinkedList<Fact>();
        for (Long factId: factsId) {
            facts.add(factManager.findFactById(factId));
        }
        original.setFacts(facts);

        return original;
    }
}
