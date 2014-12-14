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
    private String email;
    private long organisationId;

    public UserDTO(long id, String username, String email, long organisationId) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.organisationId = organisationId;
    }
    
    public UserDTO () {}

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
