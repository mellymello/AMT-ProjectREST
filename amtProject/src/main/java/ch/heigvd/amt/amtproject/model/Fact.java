/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
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
@Table(name="Fact")
@NamedQueries({
    @NamedQuery(
        name="findAllFacts",
        query ="SELECT f FROM Fact f")
})
public class Fact implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String info;
    private String type;
    private String visibility;
    
    @ManyToOne
    private Organisation organisation;

    public Fact(long id, String info, String type, String visibility, Organisation organisation) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.visibility = visibility;
        this.organisation = organisation;
    }
    
    public Fact () {}

    public long getId() {
        return id;
    }

    public String getInfo() {
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

    public void setInfo(String info) {
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
