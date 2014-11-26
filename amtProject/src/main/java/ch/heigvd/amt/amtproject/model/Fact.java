/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model;

import ch.heigvd.amt.amtproject.model.Sensor.Visibility;

/**
 *
 * @author Calixte
 */
public class Fact {
    private long id;
    private String info;
    private String type;
    private Visibility visibility;
    private long organisationID;

    public Fact(long id, String info, String type, Visibility visibility, long organisationID) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.visibility = visibility;
        this.organisationID = organisationID;
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

    public Visibility getVisibility() {
        return visibility;
    }

    public long getOrganisationID() {
        return organisationID;
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

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public void setOrganisationID(long organisationID) {
        this.organisationID = organisationID;
    }
}
