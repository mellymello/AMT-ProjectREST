/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.dto.FactDTO;
import ch.heigvd.amt.amtproject.dto.FactDTO;
import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.services.FactManagerLocal;
import ch.heigvd.amt.amtproject.services.FactManagerLocal;
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
 * @author Calixte
 */

@Path("facts")
@Stateless
public class FactResource {
    @EJB
    FactManagerLocal factManager;
    
    @Context
    private UriInfo context;
    
    public FactResource (){}
    
    @Path("{/id}")
    @GET
    @Produces("application/json")
    public FactDTO getFactDetails (@PathParam("id") long id)
    {
        Fact fact = factManager.findFactById(id);
        return toDTO(fact);
    }
    
    @POST
    @Consumes("application/json")
    public long createFact (FactDTO factDTO)
    {
        Fact newFact = new Fact();
        long id = factManager.createFact(toFact(factDTO,newFact));
        return id;
    }  
    
    @Path("{/id}")
    @PUT
    @Produces("application/json")
    public void updateFact (@PathParam("id") long id, FactDTO dto)
    {
        Fact existing = factManager.findFactById(id);
        factManager.updateFact(toFact(dto, existing));
    }
    
    @Path("{/id}")
    @DELETE
    public void deleteFact (@PathParam("id") long id)
    {
        factManager.deleteFact(id);
    }

    private FactDTO toDTO(Fact fact) {
        FactDTO factDTO = new FactDTO();
        factDTO.setId(fact.getId());
        factDTO.setInfo(fact.getInfo());
        factDTO.setType(fact.getType());
        factDTO.setOrganisationID(fact.getOrganisationID());
        factDTO.setVisibility(fact.getVisibility());

        return factDTO;
    }

    private Fact toFact(FactDTO factDTO, Fact original) {
        original.setInfo(factDTO.getInfo());
        original.setType(factDTO.getType());
        original.setOrganisationID(factDTO.getOrganisationID());
        original.setVisibility(factDTO.getVisibility());
        
        return original;
    }
}
