/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.dto;

import ch.heigvd.amt.amtproject.model.*;

/**
 *
 * @author Calixte
 */
public class OrganisationDTO {
    private long id;
    private String name;
    private User contactUser;

    public OrganisationDTO(long id, String name, User contactUser) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
    }
    
    public OrganisationDTO () {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getContactUser() {
        return contactUser;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactUser(User contactUser) {
        this.contactUser = contactUser;
    }
    
}
