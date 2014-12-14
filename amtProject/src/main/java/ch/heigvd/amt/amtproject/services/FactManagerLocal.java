/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Zak
 */
@Local
public interface FactManagerLocal {
    Fact findFactById(long factId);
    
    Fact findFactBySensorAndType(Sensor sensorId, String type);
    
    Fact findFactBySensorTypeAndDate(Sensor sensor, String type, Date date);

    List<Fact> findAllFacts();

    long createFact(Fact fact);

    void updateFact(Fact fact);

    void deleteFact(long userId);
}
