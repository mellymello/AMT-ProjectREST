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
    private Long contactUserId;

    public OrganisationDTO(long id, String name, Long contactUserId) {
        this.id = id;
        this.name = name;
        this.contactUserId = contactUserId;
    }
    
    public OrganisationDTO () {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getContactUserId() {
        return contactUserId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactUserId(Long contactUserId) {
        this.contactUserId = contactUserId;
    }
    
}
