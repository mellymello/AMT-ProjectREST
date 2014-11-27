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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Calixte
 */
@Entity
@Table(name="organisation")
@NamedQueries({
    @NamedQuery(
        name="findAllOrganisations",
        query ="SELECT * FROM organisation")
})
public class Organisation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private User contactUser;
    
    @OneToMany(mappedBy="organisation")
    LinkedList<Sensor> sensors = new LinkedList<>();
    
    LinkedList<User> users = new LinkedList<>();

    public Organisation(long id, String name, User contactUser, LinkedList<Sensor> s) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
        this.sensors = s;
    }
    
    public Organisation () {}

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
