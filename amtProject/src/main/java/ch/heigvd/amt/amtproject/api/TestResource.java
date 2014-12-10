/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.services.TestManagerLocal;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Calixte
 */
public class TestResource {
    @EJB
    TestManagerLocal testManager;
    
    @Context
    private UriInfo context;
    
    public TestResource (){}


    

}
