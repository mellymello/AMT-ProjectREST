/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : factResource.java
 * @Description : Specifiy the resources for the facts
 * @Version 1.0
 **/

package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.dto.FactDTO;
import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.services.FactManagerLocal;
import ch.heigvd.amt.amtproject.services.OrganisationManagerLocal;
import ch.heigvd.amt.amtproject.services.SensorManagerLocal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("facts")
@Stateless
public class FactResource {
    @EJB
    FactManagerLocal factManager;
    
    @EJB
    OrganisationManagerLocal organisationManager;
    
    @EJB
    SensorManagerLocal sensorManager;
    
    @Context
    private UriInfo context;
    
    public FactResource (){}
    
    @GET
    @Produces("application/json")
    public FactDTO getFactByParam (@QueryParam("sensor") Long sensorId, @QueryParam("type") String type, @DefaultValue("empty") @QueryParam("date") String textDate)
    {
        Date date = new Date();
        
        // Parsing date
        if (!textDate.equals("empty")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = sdf.parse(textDate);
            } catch (ParseException ex) {
                return null;
            }
        }
        
        // Selecting the choosen type of fact
        Fact fact = new Fact();
        if (sensorId != null && type != null) {
            if (type.equals("counter")) {
                return toDTO(factManager.findFactBySensorAndType(sensorManager.findSensorById(sensorId), type));
            }
            else if (type.equals("daily")) {
                return toDTO(factManager.findFactBySensorTypeAndDate(sensorManager.findSensorById(sensorId), type, date));
            }
        }
        return null;
    }
    
    @Path("/{id}")
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
    
    @Path("/{id}")
    @PUT
    @Produces("application/json")
    public void updateFact (@PathParam("id") long id, FactDTO dto)
    {
        Fact existing = factManager.findFactById(id);
        factManager.updateFact(toFact(dto, existing));
    }
    
    @Path("/{id}")
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
        factDTO.setOrganisationId(fact.getOrganisation().getId());
        factDTO.setVisibility(fact.getVisibility());
        factDTO.setSensorId(fact.getSensor().getId());
        factDTO.setTime(fact.getTime());

        return factDTO;
    }

    private Fact toFact(FactDTO factDTO, Fact original) {
        original.setInfo(factDTO.getInfo());
        original.setType(factDTO.getType());
        original.setOrganisation(organisationManager.findOrganisationById(factDTO.getOrganisationId()));
        original.setVisibility(factDTO.getVisibility());
        original.setSensor(sensorManager.findSensorById(factDTO.getSensorId()));
        original.setTime(factDTO.getTime());
        
        return original;
    }
}
