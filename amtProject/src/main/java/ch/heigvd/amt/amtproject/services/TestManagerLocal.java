/**
 * @Authors : Melly Calixte And Saam Frederic
 * @Name : TestManagerLocal.java
 * @Description : Business layer for the tests
 * @Version 1.0
 **/
package ch.heigvd.amt.amtproject.services;

import javax.ejb.Local;

@Local
public interface TestManagerLocal {
    public void generateData();
}
