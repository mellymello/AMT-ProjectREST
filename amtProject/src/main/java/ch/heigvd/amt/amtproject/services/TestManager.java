/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : TestManager.java
 * @Description : Business layer for the tests
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Observation;
import ch.heigvd.amt.amtproject.model.Organisation;
import ch.heigvd.amt.amtproject.model.Sensor;
import ch.heigvd.amt.amtproject.model.User;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class TestManager implements TestManagerLocal {
    
    @EJB
    private OrganisationManagerLocal organisationManager;
    
    @EJB
    private UserManagerLocal userManager;
    
    @EJB
    private SensorManagerLocal sensorManager;
    
    @EJB
    private ObservationManagerLocal observationManager;
    
    @EJB
    private FactManagerLocal factManager;
    
   
    @Override
    public void generateData() {
        // Let's create a first test organization
        Organisation org = new Organisation();
        org.setName("SuperOrg");
        long orgId = organisationManager.createOrganisation(org);
        org = organisationManager.findOrganisationById(orgId);
        
        Sensor sen = new Sensor();
        sen.setOrganisation(org);
        long sensorId = sensorManager.createSensor(sen);
        sen = sensorManager.findSensorById(sensorId);
        
        //now let's create some users for the organizations:
        List<Long> orgUsers= new ArrayList();
        for (int i = 1; i <= 5; i++) {
            orgUsers.add(userManager.createUser(new User(i, "user"+i, sha256("pass"),"user"+i+"@org1.com", org)));
            
        }
        org.setContactUser(userManager.findUserById(4));
        
        Observation obs1 = new Observation(1, new Date(), 25.0, sen);
        observationManager.createObservation(obs1);
        /*Observation obs2 = new Observation(1, new Date(), 27.0, sen);
        observationManager.createObservation(obs2);
        Observation obs3 = new Observation(1, new Date(), 24.0, sen);
        observationManager.createObservation(obs3);*/
        
        //organisationManager.updateOrganisation(org);
    }
    
    
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void resetData() {
        factManager.deleteAll();
        observationManager.deleteAll();
        sensorManager.deleteAll();
        
        
        List<Organisation> allOrg= organisationManager.findAllOrganisations();
        for (Organisation o : allOrg) {
            o.setContactUser(null);
            organisationManager.updateOrganisation(o);
        }
        
        userManager.deleteAll();
        organisationManager.deleteAll();
    }
}
