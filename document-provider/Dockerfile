FROM openjdk:11
ADD ./target/amazon-s3-0.0.1-SNAPSHOT.jar /usr/src/amazon-s3-0.0.1-SNAPSHOT.jar
EXPOSE 8080
WORKDIR usr/src
ENTRYPOINT ["java","-jar","amazon-s3-0.0.1-SNAPSHOT.jar"]

