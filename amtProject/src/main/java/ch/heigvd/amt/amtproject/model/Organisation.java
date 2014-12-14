/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : Organisation.java
 * @Description : Model for the organisations
 * @Version 1.0
 **/

package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Organisation")
@NamedQueries({
    @NamedQuery(
        name="findAllOrganisations",
        query ="SELECT o FROM Organisation o")
})
public class Organisation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private User contactUser;
    
    @OneToMany(mappedBy="organisation")
    Collection<Sensor> sensors = new LinkedList<>();
    
    @OneToMany(mappedBy="organisation")
    Collection<User> users = new LinkedList<>();
    
    @OneToMany(mappedBy="organisation")
    Collection<Fact> facts = new LinkedList<>();
    
    public Organisation(long id, String name, User contactUser, Collection<Sensor> sensors, Collection<User> users, Collection<Fact> facts) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
        this.sensors = sensors;
        this.users = users;
        this.facts = facts;
    }
    
    public Organisation () {}

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Fact> getFacts() {
        return facts;
    }

    public void setFacts(Collection<Fact> facts) {
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

    public Collection<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Collection<Sensor> sensors) {
        this.sensors = sensors;
    }
    
    
}
