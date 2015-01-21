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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Organisation")
@NamedQueries({
    @NamedQuery(
        name="findAllOrganisations",
        query ="SELECT o FROM Organisation o"),
    @NamedQuery(
        name="Organisation.deleteAll",
        query ="DELETE FROM Organisation")
})
public class Organisation implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    
    @ManyToOne
    private User contactUser;
    
    public Organisation(long id, String name, User contactUser) {
        this.id = id;
        this.name = name;
        this.contactUser = contactUser;
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
    
}
