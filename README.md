# projects2
Java Cluster aware times in WLS 12c
1) Configure on cluster

clusters--> summary of clusters --> configuration --> scheduling--> weblogic_timers

2) WL_HOME/server/db/dbname/scheduler.ddl

CREATE TABLE WEBLOGIC_TIMERS (
  TIMER_ID VARCHAR2(100) NOT NULL,
  LISTENER BLOB NOT NULL,
  START_TIME NUMBER NOT NULL,
  INTERVAL NUMBER NOT NULL,
  TIMER_MANAGER_NAME VARCHAR2(500) NOT NULL,
  DOMAIN_NAME VARCHAR2(100) NOT NULL,
  CLUSTER_NAME VARCHAR2(100) NOT NULL,
  USER_KEY VARCHAR2(1000) UNIQUE,
  PRIMARY KEY (TIMER_ID, CLUSTER_NAME, DOMAIN_NAME)
);



and a second table WL_HOME/server/db/dbname/leasing.ddl

CREATE TABLE ACTIVE (
  SERVER VARCHAR(255) NOT NULL,
  INSTANCE VARCHAR(255) NOT NULL,
  DOMAINNAME VARCHAR(255) NOT NULL,
  CLUSTERNAME VARCHAR(255) NOT NULL,
  TIMEOUT TIMESTAMP,
  PRIMARY KEY (SERVER, DOMAINNAME, CLUSTERNAME)
); 



3) weblogic-ejb-jar.xml


<weblogic-ejb-jar xmlns="http://xmlns.oracle.com/weblogic/weblogic-ejb-jar" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.oracle.com/weblogic/weblogic-ejb-jar  http://xmlns.oracle.com/weblogic/weblogic-ejb-jar/1.1/weblogic-ejb-jar.xsd"> 

<timer-implementation>Clustered</timer-implementation>

    
</weblogic-ejb-jar>
