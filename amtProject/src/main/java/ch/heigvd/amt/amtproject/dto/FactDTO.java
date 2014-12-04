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
public class FactDTO {
    private long id;
    private String info;
    private String type;
    private String visibility;
    private Organisation organisation;

    public FactDTO(long id, String info, String type, String visibility, Organisation organisation) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.visibility = visibility;
        this.organisation = organisation;
    }
    public FactDTO () {}
    
    
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
