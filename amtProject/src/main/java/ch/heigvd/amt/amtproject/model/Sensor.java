/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : Sensor.java
 * @Description : model for the sensors
 * @Version 1.0
 **/

package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="Sensor")
@NamedQueries({
    @NamedQuery(
        name="findAllSensors",
        query ="SELECT s FROM Sensor s"),
    @NamedQuery(
        name="Fact.deleteAll",
        query ="DELETE FROM Fact")
})
public class Sensor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String type;
    private String visibility;
    
    @ManyToOne
    private Organisation organisation;    

    public Sensor(long id, String name, String description, String type, String visibility, Organisation org) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.visibility = visibility;
        this.organisation = org;
    }
    public Sensor () {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }  
    
}
