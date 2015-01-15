/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : ObservationManager.java
 * @Description : Business layer for the observations
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;


import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;


@Stateless
public class ObservationManager implements ObservationManagerLocal {
    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    FactManagerLocal factManager;

    @Override
    public Observation findObservationById(long observationId) {
        return em.find(Observation.class, observationId);
    }

    @Override
    public List<Observation> findAllObservations() {
        return em.createNamedQuery("findAllObservations").getResultList();
    }
    
    @Override
    public Double findAverageObservationForOneDay(Sensor sensor) {
        Date d1 = getStartOfDay(new Date());
        Date d2 = getEndOfDay(new Date());
        return (Double) em.createNamedQuery("findAverageObservationForOneDay").setParameter("sensor", sensor).setParameter("start", d1, TemporalType.TIMESTAMP).setParameter("end", d2, TemporalType.TIMESTAMP).getSingleResult();
    }
    
    public Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    @Override
    public Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    /**
     * This method executes in a NEW transaction. When a result is returned, an exception
     * might be thrown by the container (OptimisticLockException). The caller should be 
     * able to catch it.
     */
    public long createObservation(Observation observation) {
        em.persist(observation);
        em.flush();
        
        // Creating or incrementing the counter fact
        Fact f = factManager.findFactBySensorAndType(observation.getSensor(), "counter");
        if (f != null) {
            List<Double> oldValue = f.getInfo();
            List<Double> newValue = new LinkedList<>();
            Double d = oldValue.get(0);
            d = d + 1;
            newValue.add(d);
            f.setInfo(newValue);
        }
        else {
            List<Double> info = new LinkedList<>();
            info.add(1.0);
            f = new Fact(info, "counter", "public", observation.getSensor().getOrganisation(), observation.getSensor(), new Date());
            factManager.createFact(f);
        }
        
        //Creating or updating daily fact
        Fact f1 = factManager.findFactBySensorTypeAndDate(observation.getSensor(), "daily", new Date());
        if (f1 != null) {
            List<Double> oldValue = f1.getInfo();
            List<Double> newValue = new LinkedList<>();
            
            Double min = oldValue.get(0);
            Double max = oldValue.get(1);
            Double avg = oldValue.get(2);
            
            if (observation.getValue() < min) {
                min = observation.getValue();
            }
            else if (observation.getValue() > max) {
                max = observation.getValue();
            }
            
            avg = findAverageObservationForOneDay(observation.getSensor());
            
            newValue.add(min);
            newValue.add(max);
            newValue.add(avg);
            
            f1.setInfo(newValue);
        }
        else {
            List<Double> list = new LinkedList<>();
            list.add(observation.getValue()); //Adding MIN value
            list.add(observation.getValue()); //Adding MAX value
            list.add(observation.getValue()); //Adding AVERAGE value
            
            f1 = new Fact(list, "daily", "public", observation.getSensor().getOrganisation(), observation.getSensor(), new Date());
            factManager.createFact(f1);
        }
        
        return observation.getId();
    }

    @Override
    public void updateObservation(Observation observation) {
        em.merge(observation); 
    }

    @Override
    public void deleteObservation(long observationId) {
        em.remove(em.find(Observation.class, observationId));
    }
}
