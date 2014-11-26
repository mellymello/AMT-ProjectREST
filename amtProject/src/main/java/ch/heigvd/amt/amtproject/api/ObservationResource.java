/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.dto.ObservationDTO;
import ch.heigvd.amt.amtproject.dto.ObservationDTO;
import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.services.ObservationManagerLocal;
import ch.heigvd.amt.amtproject.services.ObservationManagerLocal;
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

@Path("observations")
@Stateless
public class ObservationResource {
    @EJB
    ObservationManagerLocal observationManager;
    
    @Context
    private UriInfo context;
    
    public ObservationResource (){}
    
    @Path("{/id}")
    @GET
    @Produces("application/json")
    public ObservationDTO getObservationDetails (@PathParam("id") long id)
    {
        Observation observation = observationManager.findObservationById(id);
        return toDTO(observation);
    }
    
    @POST
    @Consumes("application/json")
    public long createObservation (ObservationDTO observationDTO)
    {
        Observation newObservation = new Observation();
        long id = observationManager.createObservation(toObservation(observationDTO,newObservation));
        return id;
    }
    
    @Path("{/id}")
    @DELETE
    public void deleteObservation (@PathParam("id") long id)
    {
        observationManager.deleteObservation(id);
    }

    private ObservationDTO toDTO(Observation observation) {
        ObservationDTO observationDTO = new ObservationDTO();
        observationDTO.setId(observation.getId());
        observationDTO.setTime(observation.getTime());
        observationDTO.setValue(observation.getValue());
        return observationDTO;
    }

    private Observation toObservation(ObservationDTO observationDTO, Observation original) {
        original.setTime(observationDTO.getTime());
        original.setValue(observationDTO.getValue());
        return original;
    }
}

