
/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : ApplicationConfig.java
 * @Description : Get the resources and specify the path
 * @Version 1.0
 **/

package ch.heigvd.amt.amtproject.api;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("v1/api")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses (resources);
        return resources;
    }
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(ch.heigvd.amt.amtproject.api.FactResource.class);
        resources.add(ch.heigvd.amt.amtproject.api.ObservationResource.class);
        resources.add(ch.heigvd.amt.amtproject.api.OrganisationResource.class);
        resources.add(ch.heigvd.amt.amtproject.api.SensorResource.class);
        resources.add(ch.heigvd.amt.amtproject.api.TestResource.class);
        resources.add(ch.heigvd.amt.amtproject.api.UserResource.class);
    }
}
