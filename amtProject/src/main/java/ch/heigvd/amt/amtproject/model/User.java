/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : User.java
 * @Description : Model for the Users
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="User")
@NamedQueries({
    @NamedQuery(
        name="findAllUsers",
        query ="SELECT u FROM User u")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Organisation organisation;

    public User(long id, String username, String password, String email, Organisation org) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.organisation = org;
    }
     
    public User (){}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Organisation getOrganisation() {
        return organisation;
    }
    

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }
    
    
    
    
}
