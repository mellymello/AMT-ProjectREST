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
public class Fact {
    private long id;
    private String info;
    private String type;
    private Visibility visbility;
    private long organisationID;
    
    public enum Visibility {visible, invisible}

    public Fact(long id, String info, String type, Visibility visbility, long organisationID) {
        this.id = id;
        this.info = info;
        this.type = type;
        this.visbility = visbility;
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

    public Visibility getVisbility() {
        return visbility;
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

    public void setVisbility(Visibility visbility) {
        this.visbility = visbility;
    }

    public void setOrganisationID(long organisationID) {
        this.organisationID = organisationID;
    }
    
    
    
    
    
    
}
