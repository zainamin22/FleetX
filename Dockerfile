FROM maven:latest AS appserver
WORKDIR /usr/src/fleetx
COPY . .
RUN mvn clean install

From tomcat:8.0.51-jre8-alpine AS production
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=appserver /usr/src/fleetx/target/ifleetx-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]