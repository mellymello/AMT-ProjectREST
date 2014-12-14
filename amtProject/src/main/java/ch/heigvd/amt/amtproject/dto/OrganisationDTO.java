/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : OrganisationDTO.java
 * @Description : DTO for the organisations
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.dto;

import ch.heigvd.amt.amtproject.model.*;
import java.util.Collection;
import java.util.LinkedList;


public class OrganisationDTO {
    private long id;
    private String name;
    private User contactUser;
    Collection<Long> sensors = new LinkedList<>();
    Collection<Long> users = new LinkedList<>();
    Collection<Long> facts = new LinkedList<>();

    public OrganisationDTO(long id, String name, User contactUser, Collection<Long> sensors, Collection<Long> users, Collection<Long> facts) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
        this.sensors = sensors;
        this.users = users;
        this.facts = facts;
    }
    
    public OrganisationDTO () {}

    public Collection<Long> getUsers() {
        return users;
    }

    public void setUsers(Collection<Long> users) {
        this.users = users;
    }

    public Collection<Long> getFacts() {
        return facts;
    }

    public void setFacts(Collection<Long> facts) {
        this.facts = facts;
    }

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
    
    public Collection<Long> getSensors() {
        return sensors;
    }

    public void setSensors(Collection<Long> sensors) {
        this.sensors = sensors;
    }
    
}
