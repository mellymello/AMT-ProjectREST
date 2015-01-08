/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : UserDTO.java
 * @Description : DTO for the users
 * @Description : 
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.dto;


public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private long organisationId;

    public UserDTO(long id, String username, String email, long organisationId, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.organisationId = organisationId;
        this.password = password;
    }
    
    public UserDTO () {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public long getOrganisationId() {
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

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }
}
