/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.dto;

import ch.heigvd.amt.amtproject.model.Organisation;

/**
 *
 * @author Calixte
 */
public class UserDto {
    private long id;
    private String username;
    private String email;
    private long organisationId;

    public UserDto(long id, String username, String email, long organisation) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.organisationId = organisation;
    }
    
    public UserDto () {}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getOrganisation() {
        return organisationId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganisation(long organisationId) {
        this.organisationId = organisationId;
    }
     
    
}
