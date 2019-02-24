FROM openjdk:11
ADD ./target/analytic-server-0.0.1-SNAPSHOT.jar /event/src/analytic-server-0.0.1-SNAPSHOT.jar
EXPOSE 8095
WORKDIR event/src
ENTRYPOINT ["java","-jar","analytic-server-0.0.1-SNAPSHOT.jar"]