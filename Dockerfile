FROM jboss/wildfly
ADD target/Docbase.war /opt/jboss/wildfly/standalone/deployments/