/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : TestResource.java
 * @Description : File for the tests of the API
 * @Version 1.0
 * 
 **/

package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.services.TestManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@Path("testData")
//@Stateless
public class TestResource {
    
    @EJB
    private TestManagerLocal testManager;
    
    @Context
    private UriInfo context;

    public TestResource() {}

    @GET
    @Path("generate")
    @Produces("application/json")
    public String generateTestData() {
        testManager.generateData();
        return "Data generated.";
    }
    
    @POST
    @Path("reset")
    public String resetTestData() {
        testManager.resetData();
        return "Data deleted.";
    }
    

}
