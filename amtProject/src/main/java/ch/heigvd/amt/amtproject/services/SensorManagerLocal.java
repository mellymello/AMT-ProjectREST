/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Sensor;
import ch.heigvd.amt.amtproject.model.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Calixte
 */
@Local
public interface SensorManagerLocal {

    List<Sensor> findAllSensors();

    Sensor findSensorById(long id);

    long createSensor(Sensor sensor);
    
    public void updateSensor(Sensor sensor);

    public void deleteSensor(long userId);
}
