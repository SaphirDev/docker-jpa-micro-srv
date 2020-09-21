FROM saphirdev/ubuntu-jdk8

#Author of the Docker File
# MAINTAINER Pictolearn Note: MAINTAINER has been deprecated for LABEL, 
# LABEL is a key value pair 
LABEL "Maintainer"="saphirDev"


ADD . /usr/local/docker-jpa-micro-srv
RUN cd /usr/local/docker-jpa-micro-srv && mvn package

# Refer to Maven build -> finalName
ARG JAR_FILE=target/docker-jpa-micro-srv-1.0.0-SNAPSHOT.jar

# cd /usr/local/docker-jpa-micro-srv/target
WORKDIR /usr/local/docker-jpa-micro-srv/target

# java -jar /usr/local/docker-jpa-micro-srv-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","docker-jpa-micro-srv-1.0.0-SNAPSHOT.jar"]

#CMD ["java", "-cp", "/usr/local/docker-jpa-micro-srv/target/docker-jpa-micro-srv-1.0.0-SNAPSHOT-jar-with-dependencies.jar", "-Dloader.main=com.omar.microservice.DockerJpaMicroSrvApplication", "org.springframework.boot.loader.PropertiesLauncher"]