/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Sensor;
import ch.heigvd.amt.amtproject.model.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Calixte
 */
@Stateless
public class SensorManager implements SensorManagerLocal {

    @Override
    public List<Sensor> findAllSensors() {
        return null;
    }

    @Override
    public Sensor findSensorById(long id) {
        return null;
    }

    @Override
    public long createSensor(Sensor sensor) {
        return 0L;
    }
    
    @Override
    public void updateSensor(Sensor sensor) {
    }

    @Override
    public void deleteSensor(long userId) {
    }
}
