#!/bin/bash
# indique au syst�me que l'argument qui suit est le programme utilis� pour ex�cuter ce fichier.
# En cas g�n�ral les "#" servent � faire des commentaires comme ici

DB_NAME=AMTDatabase
DB_TECHNICAL_USER=AMTTechnicalUser
DB_TECHNICAL_USER_PASSWORD=go
JDBC_CONNECTION_POOL_NAME="$DB_NAME"_pool
JDBC_JNDI_NAME=jdbc/"$DB_NAME"
JAR_CONNECTOR="C:/Heig/3eme/AMT"

# Partie MySQL

cd "/cygdrive/c/wamp/bin/mysql/mysql5.6.12/bin"

./mysql -u root << EOF
DROP DATABASE IF EXISTS $DB_NAME;
CREATE DATABASE $DB_NAME;

GRANT USAGE ON *.* TO '$DB_TECHNICAL_USER'@'localhost';
GRANT USAGE ON *.* TO '$DB_TECHNICAL_USER'@'%';

DROP USER '$DB_TECHNICAL_USER'@'localhost';
DROP USER '$DB_TECHNICAL_USER'@'%';

CREATE USER '$DB_TECHNICAL_USER'@'localhost' IDENTIFIED BY '$DB_TECHNICAL_USER_PASSWORD';
CREATE USER '$DB_TECHNICAL_USER'@'%' IDENTIFIED BY '$DB_TECHNICAL_USER_PASSWORD';
 
GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$DB_TECHNICAL_USER'@'localhost';
GRANT ALL PRIVILEGES ON $DB_NAME.* TO '$DB_TECHNICAL_USER'@'%'; 

USE $DB_NAME;
CREATE TABLE \`sensors\` (\`id\` int(11) NOT NULL AUTO_INCREMENT, \`description\` tinytext NOT NULL, \`type\` tinytext NOT NULL, PRIMARY KEY
(\`id\`), UNIQUE KEY \`id\` (\`id\`))
ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

 
EOF

# Partie Glassfish

cd "/cygdrive/c/Program Files/glassfish-4.1/glassfish/bin"

DOMAIN_NAME=domainAMT 

./asadmin.bat stop-domain $DOMAIN_NAME || true
./asadmin.bat delete-domain $DOMAIN_NAME || true

./asadmin.bat create-domain --nopassword=true $DOMAIN_NAME


cp $JAR_CONNECTOR/mysql-connector-java-5.1.33-bin.jar ../domains/$DOMAIN_NAME/lib

./asadmin.bat start-domain $DOMAIN_NAME


./asadmin.bat create-jdbc-connection-pool \
--restype=javax.sql.XADataSource \
--datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource \
--property User=$DB_TECHNICAL_USER:Password=$DB_TECHNICAL_USER_PASSWORD:serverName=localhost:portNumber=3306:databaseName=$DB_NAME $JDBC_CONNECTION_POOL_NAME









./asadmin.bat create-jdbc-resource --connectionpoolid $JDBC_CONNECTION_POOL_NAME $JDBC_JNDI_NAME

./asadmin.bat ping-connection-pool $JDBC_CONNECTION_POOL_NAME

exit 0
