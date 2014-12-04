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

/**
 *
 * @author Calixte
 */
public class ObservationDTO {
    private long id;
    private Date time;
    private double value;
    private Sensor sensor;

    public ObservationDTO(long id, Date time, double value, Sensor sensor) {
        this.id = id;
        this.time = time;
        this.value = value;
        this.sensor = sensor;
    }
    
    public ObservationDTO () {}

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
