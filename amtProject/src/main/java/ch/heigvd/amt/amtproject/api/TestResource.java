/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.services.TestManagerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


/**
 *
 * @author Calixte
 */
@Path("generate")
@Stateless
public class TestResource {
    
    @EJB
    private TestManagerLocal testManager;
    
    @Context
    private UriInfo context;

    public TestResource() {}

    @GET
    @Produces("application/json")
    public String generateTestData() {
        testManager.generateData();
        return "Data generated.";
    }

    

}
