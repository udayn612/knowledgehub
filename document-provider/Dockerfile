FROM openjdk:11
ADD ./target/document-provider-0.0.1-SNAPSHOT.jar /usr/src/document-provider-0.0.1-SNAPSHOT.jar
EXPOSE 8087
WORKDIR usr/src
ENTRYPOINT ["java","-jar","document-provider-0.0.1-SNAPSHOT.jar"]

