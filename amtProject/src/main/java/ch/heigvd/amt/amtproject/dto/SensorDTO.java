/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.dto;

import ch.heigvd.amt.amtproject.model.*;
import java.util.LinkedList;

/**
 *
 * @author Calixte
 */

public class SensorDTO {
    private long id;
    private String name;
    private String description;
    private String type;
    private String visibility;
    private Organisation organisation;
    

    public SensorDTO(long id, String name, String description, String type, String visibility, Organisation org) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.visibility = visibility;
        this.organisation = org;
    }
    public SensorDTO () {}

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
