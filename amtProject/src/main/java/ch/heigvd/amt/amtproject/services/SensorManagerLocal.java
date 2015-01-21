/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : SensorManagerLocal.java
 * @Description : Business layer for the sensor
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SensorManagerLocal {

    List<Sensor> findAllSensors();

    Sensor findSensorById(long id);

    long createSensor(Sensor sensor);
    
    public void updateSensor(Sensor sensor);

    public void deleteSensor(long userId);
    
    void deleteAll();
}
