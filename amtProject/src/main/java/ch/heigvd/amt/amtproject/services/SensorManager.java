/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : SensorManager.java
 * @Description : Business layer for the sensors
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class SensorManager implements SensorManagerLocal {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<Sensor> findAllSensors() {
        return em.createNamedQuery("findAllSensors").getResultList();
    }

    @Override
    public Sensor findSensorById(long id) {
        return em.find(Sensor.class, id);
    }

    @Override
    public long createSensor(Sensor sensor) {
        em.persist(sensor);
        em.flush();
        return sensor.getId();
    }
    
    @Override
    public void updateSensor(Sensor newSensor) {
        em.merge(newSensor);  
    }

    @Override
    public void deleteSensor(long userId) {
        em.remove(em.find(Sensor.class, userId));
    }
}
