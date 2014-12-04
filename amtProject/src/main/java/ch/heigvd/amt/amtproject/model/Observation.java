/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Calixte
 */
@Entity
@Table(name="observation")
@NamedQueries({
    @NamedQuery(
        name="findAllObservations",
        query ="SELECT * FROM observation")
})
public class Observation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private Date time;
    private double value;
    
    @ManyToOne
    private Sensor sensor;
    
    @ManyToMany(mappedBy="observations")
    LinkedList<Fact> facts = new LinkedList<>();

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

    public LinkedList<Fact> getFacts() {
        return facts;
    }

    public void setFacts(LinkedList<Fact> facts) {
        this.facts = facts;
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
