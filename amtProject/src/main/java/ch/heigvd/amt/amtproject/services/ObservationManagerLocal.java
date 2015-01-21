/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : ObservationManagerLocal.java
 * @Description : Business layer for the Observations
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ObservationManagerLocal {
    Observation findObservationById(long observationId);

    List<Observation> findAllObservations();
    
    Double findAverageObservationForOneDay(Sensor sensor);

    long createObservation(Observation observation);

    void updateObservation(Observation observation);

    void deleteObservation(long obsId);

    public Date getStartOfDay(Date date);
    
    void deleteAll();
}
