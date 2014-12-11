/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.dto;

import ch.heigvd.amt.amtproject.model.Fact;
import ch.heigvd.amt.amtproject.model.Sensor;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Calixte
 */
public class ObservationDTO {
    private long id;
    private Date time;
    private double value;
    private long sensorId;

    public ObservationDTO(long id, Date time, double value, long sensorId) {
        this.id = id;
        this.time = time;
        this.value = value;
        this.sensorId = sensorId;
    }
    
    public ObservationDTO () {}

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
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
