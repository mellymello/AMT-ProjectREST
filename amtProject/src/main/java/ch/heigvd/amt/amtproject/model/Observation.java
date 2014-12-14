/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : Observation.java
 * @Description : Model of the Observation
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Observation")
@NamedQueries({
    @NamedQuery(
        name="findAllObservations",
        query ="SELECT o FROM Observation o"),
    @NamedQuery(
        name="findAverageObservationForOneDay",
        query ="SELECT AVG(o.value) FROM Observation o WHERE o.sensor = :sensor AND o.time BETWEEN :start AND :end")
})
public class Observation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    private double value;
    
    @ManyToOne
    private Sensor sensor;

    public Observation(long id, Date time, double value, Sensor sensor) {
        this.id = id;
        this.time = time;
        this.value = value;
        this.sensor = sensor;
    }
    
    public Observation () {}

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    
    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public double getValue() {
        return value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
