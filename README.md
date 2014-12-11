AMT REST-API
===============
We offer a Saas platform for organisations. You can manage users, sensors, and your organisation.
The sensor generate observation and we create facts from these observations. The facts help you to analyse the results you aggregate.

#Installation
  * Clone the project
  * Install Wamp or the version for you OS (Linux : Lamp, Mac : Mamp)
  * Install Netbeans with Glassfish
  * Adapt the pathes in the script autoConfiScript.sh or you can create a "ConnectionPool" and a "JDBC with "asadmin" directly, you can find the names of all the elements in the script
  * Start the domain with asadmin
  * Start Netbeans and start the project
 
# Test Data
  * The application contains already some data, so you can test and play with it
  * If you go to : localhost:8080/amtProject/v1/api/generate, the data will be generetad for you.
  * You can populate the "Observations" with the script populateAPI.js and Node.js, it will create X observations. You can directly modify X and others parameters in the file.

#Documentation
You can find the detailled documentation about our API here : http://mellymello.github.io/AMT-ProjectREST

#Authors
Melly Calixte & SAAM Frederic
