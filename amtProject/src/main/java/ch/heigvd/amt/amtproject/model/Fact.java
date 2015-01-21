/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : Fact.java
 * @Description : Model of the facts
 * @Version 1.0
 **/

package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.Version;


@Entity
@Table(name="Fact")
@NamedQueries({
    @NamedQuery(
        name="findAllFacts",
        query ="SELECT f FROM Fact f"),
    @NamedQuery(
        name="findFactBySensorAndType",
        query ="SELECT f FROM Fact f WHERE f.sensor = :sensor AND f.type = :type"),
    @NamedQuery(
        name="findFactBySensorTypeAndDate",
        query ="SELECT f FROM Fact f WHERE f.sensor = :sensor AND f.type = :type AND f.time = :date"),
    @NamedQuery(
        name="Fact.deleteAll",
        query ="DELETE FROM Fact")
})
public class Fact implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private List<Double> info;
    private String type;
    private String visibility;
    
    @Temporal(TemporalType.DATE)
    private Date time;
    
    @ManyToOne
    private Sensor sensor;
    
    @ManyToOne
    private Organisation organisation;
    
    @Version
    long version;

    public Fact(List<Double> info, String type, String visibility, Organisation organisation, Sensor sensor, Date time) {
        //this.id = id;
        this.info = info;
        this.type = type;
        this.visibility = visibility;
        this.organisation = organisation;
        this.sensor = sensor;
        this.time = time;
    }
    
    public Fact () {}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
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

    public Organisation getOrganisation() {
        return organisation;
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

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
}
