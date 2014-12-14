/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : SensorDTO.java
 * @Description : DTO for the sensors
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.dto;



public class SensorDTO {
    private long id;
    private String name;
    private String description;
    private String type;
    private String visibility;
    private long organisationId;
    

    public SensorDTO(long id, String name, String description, String type, String visibility, long organisationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.visibility = visibility;
        this.organisationId = organisationId;
    }
    public SensorDTO () {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getVisibility() {
        return visibility;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
    
    
   
   
    
}
