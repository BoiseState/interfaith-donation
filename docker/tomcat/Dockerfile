# Docker configuration file for Apache Tomcat Server

FROM tomcat:7-jre8

# Environment variables for Docker specific configuration

ENV spring.profiles.active=docker
ENV CATALINA_OPTS="-Dspring.profile.actives=docker"

# tomcat-users.xml sets up user accounts for the Tomcat manager GUI
ADD tomcat/tomcat-users.xml $CATALINA_HOME/conf/

WORKDIR /usr/local/tomcat

# add PSQL JDBC driver jar. It allows other Java programs to
# connect to a PSQL DB using standard, DB independent Java code.
RUN wget https://jdbc.postgresql.org/download/postgresql-42.2.1.jar -P $CATALINA_HOME/lib/

ADD tomcat/run.sh $CATALINA_HOME/bin/run.sh
RUN chmod 755 $CATALINA_HOME/bin/run.sh

# Adding tomcat JPDA remote debugging env variables
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

# Launching tomcat with remote debugging
EXPOSE 8080
CMD ["run.sh"]
