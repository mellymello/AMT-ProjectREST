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
public class OrganisationDTO {
    private long id;
    private String name;
    private User contactUser;
    LinkedList<Sensor> sensors = new LinkedList<>();
    LinkedList<User> users = new LinkedList<>();
    LinkedList<Fact> facts = new LinkedList<>();

    public OrganisationDTO(long id, String name, User contactUser, LinkedList<Sensor> sensors, LinkedList<User> users, LinkedList<Fact> facts) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
        this.sensors = sensors;
        this.users = users;
        this.facts = facts;
    }
    
    public OrganisationDTO () {}

    public LinkedList<User> getUsers() {
        return users;
    }

    public void setUsers(LinkedList<User> users) {
        this.users = users;
    }

    public LinkedList<Fact> getFacts() {
        return facts;
    }

    public void setFacts(LinkedList<Fact> facts) {
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
        public LinkedList<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(LinkedList<Sensor> sensors) {
        this.sensors = sensors;
    }
    
}
