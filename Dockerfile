FROM registry.access.redhat.com/ubi8/openjdk-11

USER root

COPY src /home/app/src
COPY pom.xml /home/app

RUN yum install -y maven

#ERROR
#RUN nocmd

RUN mkdir -p /var/local/SP

RUN mvn -f /home/app/pom.xml clean package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/app/target/spring-boot-hello-world-0.0.1-SNAPSHOT.jar"]
