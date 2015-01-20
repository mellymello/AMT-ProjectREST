/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : ObservationResource.java
 * @Description : Specifiy the resources for the observations
 * @Version 1.0
 *
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.dto.ObservationDTO;
import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.services.ObservationManagerLocal;
import ch.heigvd.amt.amtproject.services.SensorManagerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("observations")
//@Stateless
public class ObservationResource {

  @EJB
  ObservationManagerLocal observationManager;

  @EJB
  SensorManagerLocal sensorManager;

  @Context
  private UriInfo context;

  public ObservationResource() {
  }

  @Path("/{id}")
  @GET
  @Produces("application/json")
  public ObservationDTO getObservationDetails(@PathParam("id") long id) {
    Observation observation = observationManager.findObservationById(id);
    return toDTO(observation);
  }

  @POST
  @Consumes("application/json")
  public long createObservation(ObservationDTO observationDTO) {
    Observation newObservation = new Observation();

    int numberOfAttempts = 100;
    boolean success = false;

    while (!success && numberOfAttempts > 0) {
      try {
        numberOfAttempts--;
        long id = observationManager.createObservation(toObservation(observationDTO, newObservation));
        success = true;
        return id;
      } catch (Exception e) {
        LOG.log(Level.INFO, "OptimisticLockException... let's try one more time... (remaining attempts: " + numberOfAttempts + ")");
        try {
          Thread.sleep((long)Math.random()*200);
        } catch (InterruptedException ex) {
          Logger.getLogger(ObservationResource.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    throw new WebApplicationException("Concurrent update!!");
  }
  private static final Logger LOG = Logger.getLogger(ObservationResource.class.getName());

  @Path("/{id}")
  @DELETE
  public void deleteObservation(@PathParam("id") long id) {
    observationManager.deleteObservation(id);
  }

  private ObservationDTO toDTO(Observation observation) {
    ObservationDTO observationDTO = new ObservationDTO();
    observationDTO.setId(observation.getId());
    observationDTO.setTime(observation.getTime());
    observationDTO.setValue(observation.getValue());
    observationDTO.setSensorId(observation.getSensor().getId());
    return observationDTO;
  }

  private Observation toObservation(ObservationDTO observationDTO, Observation original) {
    original.setTime(observationDTO.getTime());
    original.setValue(observationDTO.getValue());
    original.setSensor(sensorManager.findSensorById(observationDTO.getSensorId()));
    return original;
  }
}
