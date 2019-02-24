FROM openjdk:11
ADD ./target/content-extractor-0.0.1-SNAPSHOT.jar /usr/src/content-extractor-0.0.1-SNAPSHOT.jar
EXPOSE 8091
WORKDIR usr/src
ENTRYPOINT ["java","-jar","content-extractor-0.0.1-SNAPSHOT.jar"]
