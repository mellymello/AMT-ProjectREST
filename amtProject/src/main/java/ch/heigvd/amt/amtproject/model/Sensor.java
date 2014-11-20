/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model;

/**
 *
 * @author Calixte
 */

public class Sensor {
    private long id;
    private String name;
    private String description;
    private String type;
    private Visibility visibility;
    private long organisationId;
    
   public enum Visibility { visible , invisible};

    public Sensor(long id, String name, String description, String type, Visibility visibility, long org) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.visibility = visibility;
        this.organisationId = org;
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

    public Visibility getVisibility() {
        return visibility;
    }

    public long getOrganisation() {
        return organisationId;
    }

    public void setOrganisation(long organisationId) {
        this.organisationId = organisationId;
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

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
    
    
   
   
    
}
