/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : FactManagerLocal.java
 * @Description : Business layer for the facts
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface FactManagerLocal {
    Fact findFactById(long factId);
    
    Fact findFactBySensorAndType(Sensor sensorId, String type);
    
    Fact findFactBySensorTypeAndDate(Sensor sensor, String type, Date date);

    List<Fact> findAllFacts();

    long createFact(Fact fact);

    void updateFact(Fact fact);

    void deleteFact(long userId);
    
    void deleteAll();
}
