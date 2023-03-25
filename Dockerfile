FROM openjdk
EXPOSE 8080
ADD target/Devsu-0.0.1-SNAPSHOT.war Devsu-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/Devsu-0.0.1-SNAPSHOT.war"]