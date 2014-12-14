/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : FactDTO.java
 * @Description : DTO for the facts
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.dto;

import java.util.Date;
import java.util.List;


public class FactDTO {
    private long id;
    private List<Double> info;
    private String type;
    private String visibility;
    private long organisationId;
    private long sensorId;
    private Date time;

    public FactDTO(long id, List<Double> info, String type, String visibility, long organisationId, long sensorId, Date time) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.visibility = visibility;
        this.organisationId = organisationId;
        this.sensorId = sensorId;
        this.time = time;
    }
    public FactDTO () {}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }
    
    public long getId() {
        return id;
    }

    public List<Double> getInfo() {
        return info;
    }

    public String getType() {
        return type;
    }

    public String getVisibility() {
        return visibility;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInfo(List<Double> info) {
        this.info = info;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }  
}
