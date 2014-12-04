/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.dto;

import java.util.Date;

/**
 *
 * @author Calixte
 */
public class ObservationDTO {
    private long id;
    private Date time;
    private double value;

    public ObservationDTO(long id, Date time, double value) {
        this.id = id;
        this.time = time;
        this.value = value;
    }
    
    public ObservationDTO () {}

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
