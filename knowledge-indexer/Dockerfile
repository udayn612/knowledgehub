FROM openjdk:11
ADD ./target/knowledge-indexer-0.0.1-SNAPSHOT.jar /usr/src/knowledge-indexer-0.0.1-SNAPSHOT.jar
EXPOSE 8088
WORKDIR usr/src
ENTRYPOINT ["java","-jar","knowledge-indexer-0.0.1-SNAPSHOT.jar"]

